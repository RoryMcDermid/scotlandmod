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


public class BunnetArmorItem extends ArmorItem {

    private int buffLevel;




    public BunnetArmorItem(ArmorMaterial armorMaterial, ArmorItem.Type equipmentSlot, Properties properties, int buffLevelIn) {
        super(armorMaterial, equipmentSlot, properties);
        buffLevel = buffLevelIn;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        super.onArmorTick(stack, level, player);
//      player.sendSystemMessage((Component) new LiteralMessage("Text"));
//      Apply the scottish effect
        player.addEffect(new MobEffectInstance(ModEffects.SCOTTISH_EFFECT.get(), 20, buffLevel)); // 20 ticks duration, level 1

//
    }


}
