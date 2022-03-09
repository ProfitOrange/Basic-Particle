package com.profitorange.basic_particle;

import com.profitorange.basic_particle.init.ModParticles;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("tutorial")
public class BasicParticleMod
{
	public static final String MOD_ID = "tutorial";

    public BasicParticleMod()
    {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	ModParticles.PARTICLES.register(bus);
    }
}
