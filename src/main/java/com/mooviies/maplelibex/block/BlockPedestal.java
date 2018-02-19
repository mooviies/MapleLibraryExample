package com.mooviies.maplelibex.block;

import com.mooviies.maplelib.block.MBlockTileEntity;
import com.mooviies.maplelibex.MapleExampleMod;
import com.mooviies.maplelibex.block.tileentity.TileEntityPedestal;
import com.mooviies.maplelibex.gui.GuiHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockPedestal extends MBlockTileEntity<TileEntityPedestal> {

    public BlockPedestal() {
        super(MapleExampleMod.DESCRIPTOR, "pedestal", Material.ROCK);
        setHardness(3f);
        setResistance(5f);
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public Class<TileEntityPedestal> getTileEntityClass() {
        return TileEntityPedestal.class;
    }

    @Nullable
    @Override
    public TileEntityPedestal createTileEntity(World world, IBlockState state) {
        return new TileEntityPedestal();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote)
        {
            TileEntityPedestal tile = getTileEntity(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            if (!player.isSneaking())
            {
                Random random = new Random();
                float randomPitch = 0.5f + random.nextFloat();
                ItemStack heldItem = player.getHeldItemMainhand();
                if (heldItem.isEmpty())
                {
                    if (!itemHandler.getStackInSlot(0).isEmpty())
                    {
                        player.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
                        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1, randomPitch);
                    }
                }
                else
                {
                    if (itemHandler.getStackInSlot(0).isEmpty())
                    {
                        player.setHeldItem(hand, itemHandler.insertItem(0, heldItem, false));
                    }
                    else
                    {
                        ItemStack pedestalItemCopy = itemHandler.getStackInSlot(0).copy();
                        itemHandler.extractItem(0, 64, false);
                        itemHandler.insertItem(0, heldItem, false);
                        player.setHeldItem(hand, pedestalItemCopy);

                    }
                    world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1, randomPitch);
                }
                tile.markDirty();
            }
            else
            {
                player.openGui(MapleExampleMod.instance, GuiHandler.PEDESTAL, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityPedestal tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }
}
