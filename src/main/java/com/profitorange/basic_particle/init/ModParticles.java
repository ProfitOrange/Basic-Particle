package com.profitorange.basic_particle.init;

import com.profitorange.basic_particle.BasicParticleMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//This allows us to have the register the particle factory automatically
@Mod.EventBusSubscriber(modid = BasicParticleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModParticles 
{
	//Create a new deferred registry for our particle
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BasicParticleMod.MOD_ID);
	
	/*
	 * The particle itself.
	 * When ever you need to call this in another class use:
	 *	ModParticles.GREEN_FLAME.get()
	 */
	public static final RegistryObject<SimpleParticleType> GREEN_FLAME = PARTICLES.register("green_flame", () -> new SimpleParticleType(false));
	
	/*
	 * This registers the code that determines how the particle acts.
	 * For this example, I am just using using the default flame particle for torches.
	 * For vanilla minecraft particle classes you can go to net.minecraft.client.particle.
	 */
	@SuppressWarnings("resource")
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void registerParticleFactories(ParticleFactoryRegisterEvent event) 
	{
		Minecraft.getInstance().particleEngine.register(GREEN_FLAME.get(), FlameParticle.Provider::new);
	}
}
