package net.rory.scotlandmod.item.custom;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.rory.scotlandmod.effect.ModEffects;

import java.util.Collection;
import java.util.Map;

public class CaberetteItem extends SwordItem {


    public CaberetteItem(Tier p_43269_, int p_43270_, float AttackSpeed, Properties p_43272_) {
        super(p_43269_, p_43270_, AttackSpeed, p_43272_);
    }



    //figure out what damage values and modifiers to use
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {


        MobEffectInstance scotlandEffect = null;

        Collection<MobEffectInstance> activeEffects = attacker.getActiveEffects();
        attacker.sendSystemMessage(Component.nullToEmpty("Original damage is:" + this.getDamage()));

        // Iterate through potion effects and modify damage accordingly
        for (MobEffectInstance effectInstance : activeEffects) {

            if (effectInstance.getEffect() == ModEffects.SCOTTISH_EFFECT.get()) {


                float damageModifier = 1.0F + 0.2F * (effectInstance.getAmplifier() + 1);
                float modifiedDamage = this.getDamage() * damageModifier;
                target.hurt(DamageSource.playerAttack((Player) attacker), modifiedDamage);
                attacker.sendSystemMessage(Component.nullToEmpty("Modified damage is:" + modifiedDamage + ""));
            }
        }


        // Continue with the default behavior
        return super.hurtEnemy(stack, target, attacker);
    }

}
