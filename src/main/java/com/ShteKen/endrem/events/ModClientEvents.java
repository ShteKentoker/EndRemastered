package com.ShteKen.endrem.events;
import com.ShteKen.endrem.EndRemastered;
import com.ShteKen.endrem.util.RegistryHandler;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndRemastered.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void ActivateEndFrame(PlayerInteractEvent.RightClickItem event){
        if (event.isCancelable()) {
            if (event.getPlayer().inventory.getCurrentItem().getItem() instanceof EnderEyeItem) {
                event.setCanceled(true);
            }
        }
    }

}

