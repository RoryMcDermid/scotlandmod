package net.rory.scotlandmod.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class FieryDrinkItem extends DrinkItem {
    public FieryDrinkItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if(pLivingEntity instanceof Player){
            pLivingEntity.setSecondsOnFire(60);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
