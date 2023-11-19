package net.flippycereal.infernitemod.mixin;


import net.flippycereal.infernitemod.Infernite;
import net.flippycereal.infernitemod.item.InferniteItems;
import net.flippycereal.infernitemod.item.InferniteScytheItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    @Shadow public abstract SoundCategory getSoundCategory();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyArg(
            method = {"spawnSweepAttackParticles"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;spawnParticles(Lnet/minecraft/particle/ParticleEffect;DDDIDDDD)I"
            )
    )
    private <T extends ParticleEffect> T infernite$disableSweepingHack(T value) {
        return this.getStackInHand(Hand.MAIN_HAND).getItem() == InferniteItems.INFERNITE_SCYTHE ? (T) Infernite.RED_SCYTHE_SWEEP_ATTACK_PARTICLE : value;
    }

    @Inject(
            method = {"attack"},
            at= {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;addCritParticles(Lnet/minecraft/entity/Entity;)V"
            )}
    )
    private void attack(Entity target, CallbackInfo ci) {
        if (this.getStackInHand(Hand.MAIN_HAND).getItem() instanceof InferniteScytheItem) {
            this.getWorld().playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_FISHING_BOBBER_RETRIEVE, this.getSoundCategory(), 1.0F, 1.0F);
        }
    }
}
