package net.rory.scotlandmod.event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rory.scotlandmod.ScotlandMod;
import net.rory.scotlandmod.effect.ModEffects;
import net.rory.scotlandmod.item.ModItems;

@Mod.EventBusSubscriber(modid = ScotlandMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventSubscriber {

    @SubscribeEvent
    public static void onItemUse(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            ItemStack usedItem = event.getItem();

            // Check if the used item is the HaggisItem
            if (usedItem.getItem() == ModItems.HAGGIS.get()) {
                // Check if the player has a specific status effect (e.g., your custom effect)
                if (player.hasEffect(ModEffects.SCOTTISH_EFFECT.get())) {
                    // Apply a new status effect (e.g., DAMAGE_RESISTANCE) to the player
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0));
                }
                else {
                    player.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));
                }
            }
        }
    }

}
