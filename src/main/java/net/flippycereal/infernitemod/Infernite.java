package net.flippycereal.infernitemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.flippycereal.infernitemod.item.InferniteItems;
import net.flippycereal.infernitemod.item.InferniteTab;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Infernite implements ModInitializer {
    public static final String MOD_ID = "infernitemod";
    public static DefaultParticleType RED_SCYTHE_SWEEP_ATTACK_PARTICLE;
    /**
     * Runs the mod initializer.
     */


    public Infernite(){
    }

    private static <T extends Entity>EntityType<T> registerEntity(String s, EntityType<T> entityType) {
        return (EntityType)Registry.register(Registries.ENTITY_TYPE, "infernite:" + s, entityType);
    }

    @Override
    public void onInitialize() {
        InferniteItems.registerInferniteItems();
        InferniteTab.registerInferniteGroup();

        RED_SCYTHE_SWEEP_ATTACK_PARTICLE = (DefaultParticleType)Registry.register(Registries.PARTICLE_TYPE, "infernite:red_scythe_sweep_attack", FabricParticleTypes.simple(true));
    }
}
