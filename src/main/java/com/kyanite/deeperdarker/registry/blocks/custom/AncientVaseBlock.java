package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.SculkLeechEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class AncientVaseBlock extends Block {
    public final RandomSource randomSource = RandomSource.create();
    public AncientVaseBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Stream.of(
                Block.box(2, 1, 2, 14, 13, 14),
                Block.box(3, 0, 3, 13, 1, 13),
                Block.box(4, 13, 4, 12, 16, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        if(randomSource.nextInt(0, 6) == 0) {
            for(int i = 0; i < randomSource.nextInt(0, 4); i++) {
                SculkLeechEntity sculkLeechEntity = DDEntities.SCULK_LEECH.get().create(pLevel);
                sculkLeechEntity.moveTo(pPos.getX(), pPos.getY(), pPos.getZ(), 0, 0);
                pLevel.addFreshEntity(sculkLeechEntity);
            }
        }
    }
}
