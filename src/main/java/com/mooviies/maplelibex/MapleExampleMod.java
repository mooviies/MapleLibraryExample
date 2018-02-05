package com.mooviies.maplelibex;

import com.mooviies.maplelib.MapleMod;
import com.mooviies.maplelib.MapleModDescriptor;
import com.mooviies.maplelib.client.MapleTab;
import com.mooviies.maplelibex.gui.GuiHandler;
import com.mooviies.maplelibex.network.PacketRequestUpdatePedestal;
import com.mooviies.maplelibex.network.PacketUpdatePedestal;
import com.mooviies.maplelibex.proxy.CommonProxy;
import com.mooviies.maplelibex.registry.ModBlocks;
import com.mooviies.maplelibex.registry.ModItems;
import com.mooviies.maplelibex.registry.ModRecipes;
import com.mooviies.maplelibex.world.ModWorldGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = MapleExampleMod.MODID, name = MapleExampleMod.NAME, version = MapleExampleMod.VERSION, dependencies = "required-after:maplelib@[1.12.2-0.0.3.0,)")
public class MapleExampleMod
{
    public static final String GROUPID = "com.mooviies";
    public static final String MODID = "maplelibex";
    public static final String PACKAGE = GROUPID + "." + MODID;
    public static final String NAME = "Maple Library Example";
    public static final String VERSION = "1.12.2-0.0.3.0";
    public static final MapleModDescriptor DESCRIPTOR = new MapleExampleDescriptor();
    public static final MapleTab CREATIVE_TAB = new MapleTab(DESCRIPTOR, () -> ModItems.ingotCopper);

    public static SimpleNetworkWrapper network;

    @SidedProxy(serverSide = PACKAGE + ".proxy.CommonProxy", clientSide = PACKAGE + ".proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static MapleExampleMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(NAME + " is loading!");
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        ModBlocks.initializeStaticField();
        ModItems.initializeStaticField();

        proxy.registerRenderers();

        network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        network.registerMessage(new PacketUpdatePedestal.Handler(), PacketUpdatePedestal.class, 0, Side.CLIENT);
        network.registerMessage(new PacketRequestUpdatePedestal.Handler(), PacketRequestUpdatePedestal.class, 1, Side.SERVER);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
