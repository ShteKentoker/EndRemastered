package com.ShteKen.endrem.util;

import com.ShteKen.endrem.EndRemastered;
import com.ShteKen.endrem.blocks.DiaLight;
import com.ShteKen.endrem.blocks.EndCreator;
import com.ShteKen.endrem.blocks.OldFrame;
import com.ShteKen.endrem.items.EnderEyeR;
import com.ShteKen.endrem.items.ItemBase;
import com.ShteKen.endrem.lists.BiomeList;
import com.ShteKen.endrem.world.biome.EndLandBiome;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndRemastered.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EndRemastered.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, EndRemastered.MOD_ID);

    public static void init() {

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Item
    public static final RegistryObject<Item> OLD_PEARL = ITEMS.register("old_pearl", ItemBase::new);
    public static final RegistryObject<Item> ROGUE_PEARL = ITEMS.register("rogue_pearl", ItemBase::new);
    public static final RegistryObject<Item> NETHER_PEARL = ITEMS.register("nether_pearl", ItemBase::new);
    public static final RegistryObject<Item> COLD_PEARL = ITEMS.register("cold_pearl", ItemBase::new);
    public static final RegistryObject<Item> CORRUPTED_PEARL = ITEMS.register("corrupted_pearl", ItemBase::new);
    public static final RegistryObject<Item> MAGICAL_PEARL = ITEMS.register("magical_pearl", ItemBase::new);
    public static final RegistryObject<Item> BLACK_PEARL = ITEMS.register("black_pearl", ItemBase::new);
    public static final RegistryObject<Item> LOST_PEARL = ITEMS.register("lost_pearl", ItemBase::new);
    public static final RegistryObject<Item> CORE = ITEMS.register("core", ItemBase::new);
    public static final RegistryObject<Item> POWERED_CORE = ITEMS.register("powered_core", ItemBase::new);
    public static final RegistryObject<Item> EYE_PEARLE = ITEMS.register("eye_pearl", EnderEyeR::new);



    //Block
    public static final RegistryObject<Block> END_CREATOR = BLOCKS.register("end_creator", EndCreator::new);

    public static final RegistryObject<Block> OLD_FRAME = BLOCKS.register("old_frame", OldFrame::new);
    public static final RegistryObject<Block> ROGUE_FRAME = BLOCKS.register("rogue_frame", OldFrame::new);
    public static final RegistryObject<Block> NETHER_FRAME = BLOCKS.register("nether_frame", OldFrame::new);
    public static final RegistryObject<Block> COLD_FRAME = BLOCKS.register("cold_frame", OldFrame::new);
    public static final RegistryObject<Block> CORRUPTED_FRAME = BLOCKS.register("corrupted_frame", OldFrame::new);
    public static final RegistryObject<Block> MAGICAL_FRAME = BLOCKS.register("magical_frame", OldFrame::new);
    public static final RegistryObject<Block> BLACK_FRAME = BLOCKS.register("black_frame", OldFrame::new);
    public static final RegistryObject<Block> LOST_FRAME = BLOCKS.register("lost_frame", OldFrame::new);
    public static final RegistryObject<Block> DIA_LIGHT = BLOCKS.register("dia_light", DiaLight::new);




    //Block Item

    public static final RegistryObject<Item> END_CREATOR_ITEM = ITEMS.register("end_creator", () -> new BlockItem(END_CREATOR.get(), new Item.Properties().group(EndRemastered.TAB)));

    public static final RegistryObject<Item> OLD_FRAME_ITEM = ITEMS.register("old_frame", () -> new BlockItem(OLD_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> ROGUE_FRAME_ITEM = ITEMS.register("rogue_frame", () -> new BlockItem(ROGUE_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> NETHER_FRAME_ITEM = ITEMS.register("nether_frame", () -> new BlockItem(NETHER_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> COLD_FRAME_ITEM = ITEMS.register("cold_frame", () -> new BlockItem(COLD_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> CORRUPTED_FRAME_ITEM = ITEMS.register("corrupted_frame", () -> new BlockItem(CORRUPTED_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> MAGICAL_FRAME_ITEM = ITEMS.register("magical_frame", () -> new BlockItem(MAGICAL_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> BLACK_FRAME_ITEM = ITEMS.register("black_frame", () -> new BlockItem(BLACK_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> LOST_FRAME_ITEM = ITEMS.register("lost_frame", () -> new BlockItem(LOST_FRAME.get(), new Item.Properties().group(EndRemastered.TAB)));
    public static final RegistryObject<Item> DIA_LIGHT_ITEM = ITEMS.register("dia_light", () -> new BlockItem(DIA_LIGHT.get(), new Item.Properties().group(EndRemastered.TAB)));

    //Biomes

   // public static final RegistryObject<Biome> END_LAND = BIOMES.register("end_land", EndLandBiome::new);


}
