package net.flippycereal.infernitemod.item;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.flippycereal.infernitemod.Infernite;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.event.GameEvent;

public class InferniteScytheItem extends SwordItem{
    public InferniteScytheItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            this.spawnSweepParticles((PlayerEntity)attacker, Infernite.RED_SCYTHE_SWEEP_ATTACK_PARTICLE);
            SoundEvent sound = SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP;
            attacker.getWorld().playSound((PlayerEntity)null, target.getX(), target.getY(), target.getZ(), sound, attacker.getSoundCategory(), 1.0f, 1.0f);
        }
        if (!attacker.getWorld().isClient && attacker.getEquippedStack(EquipmentSlot.MAINHAND).isOf(this)) {
            target.setFireTicks(300);
            if (target.isDead()) {
                attacker.heal(5);
            }
            attacker.heal(3);
            attacker.damageShield(50);
            attacker.disablesShield();
        }
        return super.postHit(stack, target, attacker);
    }

    public void spawnSweepParticles(PlayerEntity player, DefaultParticleType type) {
        double d0 = (double)(MathHelper.sin(player.getYaw() * 0.017453292F));
        double d1 = (double)(MathHelper.cos(player.getYaw() * 0.017453292F));
        if (player.getWorld() instanceof ServerWorld) {
            ((ServerWorld) player.getWorld()).spawnParticles(type, player.getX() + d0, player.getBodyY(0.5), player.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }
    }
}