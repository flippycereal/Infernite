package net.flippycereal.infernitemod.particle;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class ScytheAttackParticle extends SpriteBillboardParticle {
    private SpriteProvider spriteWithAge;

    public ScytheAttackParticle(ClientWorld world, double x, double y, double z, double velocityX, SpriteProvider spriteSet) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.spriteWithAge = spriteWithAge;
        this.maxAge = 4;
        float f = this.random.nextFloat() * 0.6F + 0.4F;
        this.red = f;
        this.green = f;
        this.blue = f;
        this.scale = 1.0f - (float)scale * 0.5F;
        this.setSpriteForAge(spriteWithAge);
    }

    @Override
    protected int getBrightness(float tint) {
        return 15728880;
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.setSpriteForAge(this.spriteWithAge);
        }
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    @Environment(EnvType.CLIENT)
    public static record Factory(SpriteProvider spriteSet) implements ParticleFactory<DefaultParticleType> {
        public Factory(SpriteProvider spriteSet) {
            this.spriteSet = spriteSet;
        }
        public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new ScytheAttackParticle(world, x, y, z, velocityX, this.spriteSet);
        }

        public SpriteProvider spriteSet() {
            return this.spriteSet;
        }
    }
}
