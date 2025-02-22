package com.tutuplay2222.sounds;

import com.tutuplay2222.russiancookingmod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = 
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, russiancookingmod.MODID);

    // Звук тертой моркови
    public static final RegistryObject<SoundEvent> GRATER_INTERACT = 
        SOUND_EVENTS.register("grater_interact", 
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(russiancookingmod.MODID, "grater_interact")));


    // Метод регистрации звуков
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}