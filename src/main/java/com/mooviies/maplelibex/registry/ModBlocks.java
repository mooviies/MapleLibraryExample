package com.mooviies.maplelibex.registry;

import com.mooviies.maplelib.block.MBlockCrops;
import com.mooviies.maplelib.block.MBlockOre;
import com.mooviies.maplelib.registry.MapleBlocks;
import com.mooviies.maplelibex.MapleExampleMod;
import com.mooviies.maplelibex.block.*;

public class ModBlocks extends MapleBlocks {
    public static MBlockOre oreCopper = new MBlockOre(MapleExampleMod.DESCRIPTOR, "ore_copper", "oreCopper");
    public static MBlockCrops cropCorn = new MBlockCrops("crop_corn", ModItems.cornSeed, ModItems.corn);
    public static BlockPedestal pedestal = new BlockPedestal();
    public static BlockCounter counter = new BlockCounter();

    public static void initializeStaticField() {

    }
}
