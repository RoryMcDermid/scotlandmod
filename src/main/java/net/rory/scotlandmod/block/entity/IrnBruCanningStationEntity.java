package net.rory.scotlandmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.rory.scotlandmod.block.ModBlocks;
import net.rory.scotlandmod.item.ModItems;
import net.rory.scotlandmod.recipe.IrnBruCanningStationRecipe;
import net.rory.scotlandmod.screen.IrnBruCanningStationMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class IrnBruCanningStationEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(3){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public IrnBruCanningStationEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CANNING_STATION.get(), blockPos, blockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> IrnBruCanningStationEntity.this.progress;
                    case 1 -> IrnBruCanningStationEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> IrnBruCanningStationEntity.this.progress = value;
                    case 1 -> IrnBruCanningStationEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Irn Bru Canning Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new IrnBruCanningStationMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    public static void tick(Level level, BlockPos blockPos, BlockState blockState, IrnBruCanningStationEntity iEntity) {
        if(level.isClientSide()){
            return;
        }

        if(hasRecipe(iEntity)){
            iEntity.progress++;
            setChanged(level, blockPos, blockState);

            if(iEntity.progress >= iEntity.maxProgress){
                craftItem(iEntity);
            }
        } else {
            iEntity.resetProgress();
            setChanged(level, blockPos, blockState);
        }




    }

    public void resetProgress(){
        this.progress = 0;
    }

    public static void craftItem(IrnBruCanningStationEntity pEntity){
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<IrnBruCanningStationRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(IrnBruCanningStationRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(pEntity)) {
            pEntity.itemHandler.extractItem(0, 1, false);
            pEntity.itemHandler.extractItem(1, 1, false);
            pEntity.itemHandler.setStackInSlot(2, new ItemStack(recipe.get().getResultItem().getItem(),
                    pEntity.itemHandler.getStackInSlot(2).getCount() + recipe.get().getResultItem().getCount()));

            pEntity.resetProgress();
        }
    }

    public static boolean hasRecipe(IrnBruCanningStationEntity iEntity){
        Level level = iEntity.level;

        SimpleContainer inventory = new SimpleContainer(iEntity.itemHandler.getSlots());
        for (int i = 0; i < iEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, iEntity.itemHandler.getStackInSlot(i));
        }

        Optional<IrnBruCanningStationRecipe> can = level.getRecipeManager()
                .getRecipeFor(IrnBruCanningStationRecipe.Type.INSTANCE, inventory, level);

        return can.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, can.get().getResultItem());

    }

    public static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack itemStack){
        return inventory.getItem(2).getItem() == itemStack.getItem() || inventory.getItem(2).isEmpty();
    }

    public static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory){
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
