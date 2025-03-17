package com.tutuplay2222;

import com.tutuplay2222.block.GraterBlock;
import com.tutuplay2222.items.moditems;
import com.tutuplay2222.loot.ModLootModifiers;
import com.tutuplay2222.sounds.ModSounds;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod("russiancookingmod")
public class russiancookingmod {
    public static final String MODID = "russiancookingmod";
    public static CreativeModeTab RUSSIAN_COOKING_TAB;

    public russiancookingmod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
        
        
        ModSounds.register(bus);
        moditems.ITEMS.register(bus);
        moditems.BLOCKS.register(bus);
        ModLootModifiers.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
        // Добавление слушателя для инициализации
        bus.addListener(this::init);
        bus.addListener(this::registerCreativeTab);
    }

    private void init(final FMLCommonSetupEvent event) {
        // Здесь можно добавить другие инициализации, если нужно
    }

    private void registerCreativeTab(CreativeModeTabEvent.Register event) {
        RUSSIAN_COOKING_TAB = event.registerCreativeModeTab(
            new ResourceLocation(MODID, "russian_cooking_tab"),
            builder -> builder
                .title(Component.translatable("creativetab." + MODID + ".russian_cooking_tab"))
                .icon(() -> new ItemStack(moditems.LOGO.get()))
                .displayItems((enabledFlags, populator) -> {
                    populator.accept(moditems.WOODEN_LADLE.get());
                    populator.accept(moditems.STONE_LADLE.get());
                    populator.accept(moditems.IRON_LADLE.get());
                    populator.accept(moditems.GOLDEN_LADLE.get());
                    populator.accept(moditems.DIAMOND_LADLE.get());
                    populator.accept(moditems.NETHERITE_LADLE.get());
                    // Существующие предметы
                    populator.accept(moditems.SHAVERMA.get());
                    populator.accept(moditems.SANDWICH.get());

                    populator.accept(moditems.PETRI_DISH.get());
                    populator.accept(moditems.HEATED_MILK.get());
                    populator.accept(moditems.PETRI_DISH_MILK_BACTERIA_YOGURT.get());
                    populator.accept(moditems.PETRI_DISH_MILK_BACTERIA_SOUR_CREAM.get());
                    populator.accept(moditems.PETRI_DISH_MILK_BACTERIA_WHEY.get());
                    
                    populator.accept(moditems.YOGURT.get());
                    populator.accept(moditems.SOUR_CREAM.get());
                    populator.accept(moditems.WHEY.get());
                    
                    populator.accept(moditems.DOUGH.get());
                    populator.accept(moditems.LEPESHKA.get());
                    populator.accept(moditems.COOKED_LEPESHKA.get());
                    
                    populator.accept(moditems.COAL_SALT.get());
                    populator.accept(moditems.RAW_COAL_MIXTURE.get());
                    populator.accept(moditems.FOOD_COAL_SALT.get());
                    
                    populator.accept(moditems.GRATER_ITEM.get());
                    populator.accept(moditems.GRATED_CARROT.get());
                    populator.accept(moditems.GRATED_POTATO.get());
                    
                    populator.accept(Items.MILK_BUCKET);

                    populator.accept(moditems.KOREAN_CARROT.get());
                })
        );
    }
@Mod.EventBusSubscriber(modid = russiancookingmod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SuppressWarnings("removal")
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Указываем тип рендера для блока (например, прозрачный или непрозрачный)
        ItemBlockRenderTypes.setRenderLayer(moditems.GRATER.get(), RenderType.cutout());
    }
}
}