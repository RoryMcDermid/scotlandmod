package net.rory.scotlandmod.item.custom;

import com.mojang.brigadier.LiteralMessage;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.rory.scotlandmod.effect.ModEffects;


public class ScottishArmorItem extends ArmorItem {

    private int buffLevel;




    public ScottishArmorItem(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, Properties properties, int buffLevelIn) {
        super(armorMaterial, equipmentSlot, properties);
        buffLevel = buffLevelIn;
    }

    private int getNumEquipped(Player player) {
        int count = 0;
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (armorStack.getItem() instanceof ScottishArmorItem) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        super.onArmorTick(stack, level, player);
//      player.sendSystemMessage((Component) new LiteralMessage("Text"));
//      Apply the scottish effect
        int actualBuffLevel = getNumEquipped(player) * (buffLevel + 1) - 1;
        player.addEffect(new MobEffectInstance(ModEffects.SCOTTISH_EFFECT.get(), 20, actualBuffLevel)); // 20 ticks duration, level 1

//
    }


}
