package com.mooviies.maplelibex;

import com.mooviies.maplelib.MapleMod;
import com.mooviies.maplelib.client.MapleTab;
import com.mooviies.maplelibex.gui.GuiHandler;
import com.mooviies.maplelibex.proxy.CommonProxy;
import com.mooviies.maplelibex.registry.ModItems;
import com.mooviies.maplelibex.world.ModWorldGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MapleExampleMod.MODID, name = MapleExampleMod.NAME, version = MapleExampleMod.VERSION)
public class MapleExampleMod extends MapleMod
{
    public static final String GROUPID = "com.mooviies";
    public static final String MODID = "maplelibex";
    public static final String PACKAGE = GROUPID + "." + MODID;
    public static final String NAME = "Maple Library Example";
    public static final String VERSION = "1.0.0";

    @SidedProxy(serverSide = PACKAGE + ".proxy.CommonProxy", clientSide = PACKAGE+ ".proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static MapleExampleMod instance;

    public static final MapleTab creativeTab = new MapleTab(ModItems.ingotCopper);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(NAME + " is loading!");
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
    }
}
