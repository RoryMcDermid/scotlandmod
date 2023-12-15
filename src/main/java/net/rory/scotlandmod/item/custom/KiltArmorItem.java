package net.rory.scotlandmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.rory.scotlandmod.effect.ModEffects;


public class KiltArmorItem extends ArmorItem {

    private int buffLevel;




    public KiltArmorItem(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, Properties properties, int buffLevelIn) {
        super(armorMaterial, equipmentSlot, properties);
        buffLevel = buffLevelIn;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        super.onArmorTick(stack, level, player);
        // Check if the armor is worn on the player's head
        // Apply the scottish effect
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, buffLevel)); // 20 ticks duration, level 1

    }


}
