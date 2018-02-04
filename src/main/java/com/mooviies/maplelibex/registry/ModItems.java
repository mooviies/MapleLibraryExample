package com.mooviies.maplelibex.registry;

import com.mooviies.maplelib.item.MItemFood;
import com.mooviies.maplelib.item.MItemOre;
import com.mooviies.maplelib.item.MItemSeeds;
import com.mooviies.maplelib.item.armor.MItemArmor;
import com.mooviies.maplelib.item.tool.*;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ModItems {
    public static MItemOre ingotCopper = new MItemOre("ingot_copper", "ingotCopper");

    public static MItemSeeds cornSeed = new MItemSeeds("corn_seed", () -> ModBlocks.cropCorn, Blocks.FARMLAND);
    public static MItemFood corn = new MItemFood("corn", "cropCorn", 3, 0.6f, false);

    public static MItemAxe copperAxe = new MItemAxe("copper_axe", ModMaterials.copperToolMaterial, 9.0f, -3.1f);
    public static MItemHoe copperHoe = new MItemHoe("copper_hoe", ModMaterials.copperToolMaterial);
    public static MItemPickaxe copperPickaxe = new MItemPickaxe("copper_pickaxe", ModMaterials.copperToolMaterial);
    public static MItemShovel copperShovel = new MItemShovel("copper_shovel", ModMaterials.copperToolMaterial);
    public static MItemSword copperSword = new MItemSword("copper_sword", ModMaterials.copperToolMaterial);

    public static MItemArmor copperHelmet = new MItemArmor("copper_helmet", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.HEAD);
    public static MItemArmor copperChestplate  = new MItemArmor("copper_chestplate", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.CHEST);
    public static MItemArmor copperLeggings   = new MItemArmor("copper_leggings", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.LEGS);
    public static MItemArmor copperBoots  = new MItemArmor("copper_boots", ModMaterials.copperArmorMaterial, EntityEquipmentSlot.FEET);
}
