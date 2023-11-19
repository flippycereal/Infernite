package net.flippycereal.infernitemod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.flippycereal.infernitemod.Infernite;
import net.flippycereal.infernitemod.particle.ScytheAttackParticle;

public class InferniteClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(Infernite.RED_SCYTHE_SWEEP_ATTACK_PARTICLE, ScytheAttackParticle.Factory::new);

    }
}
