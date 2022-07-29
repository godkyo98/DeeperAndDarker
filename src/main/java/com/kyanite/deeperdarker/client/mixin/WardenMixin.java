package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Warden.class)
public abstract class WardenMixin extends Entity {
    private ServerBossEvent bossEvent = (ServerBossEvent)(
            new ServerBossEvent(this.getDisplayName(),
                    BossEvent.BossBarColor.BLUE,
                    BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    public WardenMixin(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void kill() {
        super.kill();
        this.bossEvent.removeAllPlayers();
    }

    @Inject(method = "createAttributes", at = @At("RETURN"), cancellable = true)
    private static void createAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        cir.setReturnValue(Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 350).add(Attributes.MOVEMENT_SPEED, (double) 0.3F).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.ATTACK_KNOCKBACK, 1.5D).add(Attributes.ATTACK_DAMAGE, 15));
    }

    @Inject(method = "customServerAiStep", at = @At("HEAD"), cancellable = true)
    public void serverStep(CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity)(Object)this;

        if(livingEntity.getHealth() > 2){
            for(ServerPlayer plr : livingEntity.getServer().getLevel(livingEntity.level.dimension()).players()) {
                if(!this.bossEvent.getPlayers().contains(plr))
                    this.bossEvent.addPlayer(plr);
            }

            for(ServerPlayer plr : this.bossEvent.getPlayers()) {
                if(plr.distanceTo(livingEntity) > 25)
                    this.bossEvent.removePlayer(plr);
            }

            this.bossEvent.setProgress(livingEntity.getHealth() / livingEntity.getMaxHealth());
        }
    }
}
