package com.mooviies.maplelibex.proxy;

import com.mooviies.maplelibex.block.tileentity.TESRPedestal;
import com.mooviies.maplelibex.block.tileentity.TileEntityPedestal;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new TESRPedestal());
    }
}
