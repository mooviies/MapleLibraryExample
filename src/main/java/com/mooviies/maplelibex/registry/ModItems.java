package com.mooviies.maplelibex.registry;

import com.mooviies.maplelib.item.MItemFood;
import com.mooviies.maplelib.item.MItemOre;
import com.mooviies.maplelib.item.MItemSeeds;
import com.mooviies.maplelib.item.armor.MItemArmor;
import com.mooviies.maplelib.item.tool.*;
import com.mooviies.maplelibex.MapleExampleMod;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ModItems {
    public static MItemOre ingotCopper = new MItemOre(MapleExampleMod.DESCRIPTOR, "ingot_copper", "ingotCopper");

    public static MItemSeeds cornSeed = new MItemSeeds(MapleExampleMod.DESCRIPTOR, "corn_seed", () -> ModBlocks.cropCorn, Blocks.FARMLAND);
    public static MItemFood corn = new MItemFood(MapleExampleMod.DESCRIPTOR, "corn", "cropCorn", 3, 0.6f, false);

    public static MItemAxe copperAxe = new MItemAxe(MapleExampleMod.DESCRIPTOR, "copper_axe", ModMaterials.copperToolMaterial, 9.0f, -3.1f);
    public static MItemHoe copperHoe = new MItemHoe(MapleExampleMod.DESCRIPTOR, "copper_hoe", ModMaterials.copperToolMaterial);
    public static MItemPickaxe copperPickaxe = new MItemPickaxe(MapleExampleMod.DESCRIPTOR, "copper_pickaxe", ModMaterials.copperToolMaterial);
    public static MItemShovel copperShovel = new MItemShovel(MapleExampleMod.DESCRIPTOR, "copper_shovel", ModMaterials.copperToolMaterial);
    public static MItemSword copperSword = new MItemSword(MapleExampleMod.DESCRIPTOR, "copper_sword", ModMaterials.copperToolMaterial);

    public static MItemArmor copperHelmet = new MItemArmor(MapleExampleMod.DESCRIPTOR, "copper_helmet", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.HEAD);
    public static MItemArmor copperChestplate  = new MItemArmor(MapleExampleMod.DESCRIPTOR, "copper_chestplate", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.CHEST);
    public static MItemArmor copperLeggings   = new MItemArmor(MapleExampleMod.DESCRIPTOR, "copper_leggings", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.LEGS);
    public static MItemArmor copperBoots  = new MItemArmor(MapleExampleMod.DESCRIPTOR, "copper_boots", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.FEET);

    public static void initializeStaticField() {

    }
}
