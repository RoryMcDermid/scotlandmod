package net.rory.scotlandmod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.rory.scotlandmod.ScotlandMod;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {


    WOOLEN("woolen", 5, new int[]{1, 1, 2, 1}, 15, SoundEvents.WOOL_PLACE, 0.0F, 0.0F, () -> {
        //This is the item that repairs it
        return Ingredient.of(Items.WHITE_WOOL);
    }),
    CHAIN_WOOLEN("chain_woolen", 15, new int[] {1,4,3,1}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0f, 0.0f, () -> {
        //This is the item that repairs it
        return Ingredient.of(Items.CHAIN);
    }),
    IRON_WOOLEN("iron_woolen", 15, new int[] {1,5,4,1}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> {
        //This is the item that repairs it
        return Ingredient.of(Items.IRON_INGOT);
    }),
    GOLD_WOOLEN("gold_woolen", 7, new int[] {1,4,2,1}, 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.0f, 0.0f, () -> {
        //This is the item that repairs it
        return Ingredient.of(Items.GOLD_INGOT);
    }),
    DIAMOND_WOOLEN("diamond_woolen", 33, new int[] {2,7,5,2}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> {
        //This is the item that repairs it
        return Ingredient.of(Items.DIAMOND);
    }),
    NETHERITE_WOOLEN("netherite_woolen", 37, new int[] {2,7,5,2}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5f, 0.1f, () -> {
        //This is the item that repairs it
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),
    CREATIVE_WOOLEN("creative_woolen", 100, new int[] {10,10,10,10}, 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0f, 0.25f, () -> {
        //This is the item that repairs it
        return Ingredient.of(Items.NETHERITE_INGOT);
    });

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModArmorMaterials(String p_40474_, int p_40475_, int[] p_40476_, int p_40477_, SoundEvent p_40478_, float p_40479_, float p_40480_, Supplier<Ingredient> p_40481_) {
        this.name = p_40474_;
        this.durabilityMultiplier = p_40475_;
        this.slotProtections = p_40476_;
        this.enchantmentValue = p_40477_;
        this.sound = p_40478_;
        this.toughness = p_40479_;
        this.knockbackResistance = p_40480_;
        this.repairIngredient = new LazyLoadedValue<>(p_40481_);
    }

    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot p_40487_) {
        return this.slotProtections[p_40487_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return ScotlandMod.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
