package com.mooviies.maplelibex;

import com.mooviies.maplelib.MapleModDescriptor;
import net.minecraft.creativetab.CreativeTabs;

public class MapleExampleDescriptor extends MapleModDescriptor {
    @Override
    public String getGroupID() {
        return MapleExampleMod.GROUPID;
    }

    @Override
    public String getModID() {
        return MapleExampleMod.MODID;
    }

    @Override
    public String getPackage() {
        return MapleExampleMod.PACKAGE;
    }

    @Override
    public String getName() {
        return MapleExampleMod.NAME;
    }

    @Override
    public String getVersion() {
        return MapleExampleMod.VERSION;
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return MapleExampleMod.CREATIVE_TAB;
    }
}
