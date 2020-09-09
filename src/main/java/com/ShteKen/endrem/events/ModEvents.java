package com.ShteKen.endrem.events;


import net.minecraft.item.EnderEyeItem;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModEvents {


    @SubscribeEvent
    public static void IsInEnd(PlayerInteractEvent.RightClickBlock event){
        if (event.isCancelable()) {
            if (event.getPlayer().inventory.getCurrentItem().getItem() instanceof EnderEyeItem) {
                event.setCanceled(true);
            }
        }
    }

}

