package com.ShteKen.endrem.events;

import com.ShteKen.endrem.EndRemastered;
import com.ShteKen.endrem.lists.BiomeList;
import com.ShteKen.endrem.world.biome.EndLandBiome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndRemastered.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterEventHandler {

    public static final String MOD_ID = "endrem";

    @SubscribeEvent
    public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
        event.getRegistry().registerAll
                (
                        BiomeList.end_land = new EndLandBiome()


                );
    BiomeList.registerBiomes();
    }
    public  static ResourceLocation location(String name) {
        return new ResourceLocation(EndRemastered.MOD_ID, name);
    }
}
