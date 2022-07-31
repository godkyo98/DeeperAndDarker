package com.kyanite.deeperdarker.client.rendering.entity.renderer;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.client.rendering.entity.model.SculkWormModel;
import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SculkWormRenderer extends GeoEntityRenderer<SculkWormEntity> {
    public SculkWormRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SculkWormModel());
    }

    @Override
    public ResourceLocation getTextureLocation(SculkWormEntity instance) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/sculk_worm.png");
    }

    @Override
    public RenderType getRenderType(SculkWormEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        stack.scale(1f, 1f, 1f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}