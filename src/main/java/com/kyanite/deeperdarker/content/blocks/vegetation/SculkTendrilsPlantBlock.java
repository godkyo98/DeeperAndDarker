package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SculkTendrilsPlantBlock extends GrowingPlantBodyBlock {
    public static final MapCodec<SculkTendrilsPlantBlock> CODEC = simpleCodec(SculkTendrilsPlantBlock::new);
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);

    public SculkTendrilsPlantBlock(Properties properties) {
        super(properties, Direction.UP, SHAPE, false);
    }

    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return DDBlocks.SCULK_TENDRILS.get();
    }

    @Override
    protected @NotNull MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }
}
