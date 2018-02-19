package com.mooviies.maplelibex.block.tileentity;

import com.mooviies.maplelib.block.tileentity.MTileEntity;
import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainerInventory;
import com.mooviies.maplelib.block.tileentity.capability.CapabilityContainerTime;
import com.mooviies.maplelibex.MapleExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityPedestal extends MTileEntity {

    public TileEntityPedestal()
    {
        addCapability(new CapabilityContainerInventory(this, true, 1));
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
    }
}
