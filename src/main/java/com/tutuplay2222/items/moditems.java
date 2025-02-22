package com.tutuplay2222.items;

import com.tutuplay2222.russiancookingmod;
import com.tutuplay2222.block.GraterBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

public class moditems {
    public static final String MODID = russiancookingmod.MODID;

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    // В классе moditems.java
    public static final RegistryObject<Block> GRATER = BLOCKS.register("grater", 
        () -> new GraterBlock(BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.6f)
            .sound(SoundType.STONE)));

    public static final RegistryObject<Item> GRATER_ITEM = ITEMS.register("grater", 
        () -> new BlockItem(GRATER.get(), new Item.Properties()));

    // Убедитесь, что вы также зарегистрировали grater_interact
    public static final RegistryObject<SoundEvent> GRATER_INTERACT = 
        SOUND_EVENTS.register("block.russiancookingmod.grater_interact", 
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(russiancookingmod.MODID, "sounds/block/grater_interact.ogg")));


    // Петри
    public static final RegistryObject<Item> PETRI_DISH = ITEMS.register("petri_dish", 
        () -> new Item(new Item.Properties().stacksTo(16)));
    
    public static final RegistryObject<Item> PETRI_DISH_MILK_BACTERIA_YOGURT = ITEMS.register("petri_dish_milk_bacteria_yogurt", 
        () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> PETRI_DISH_MILK_BACTERIA_SOUR_CREAM = ITEMS.register("petri_dish_milk_bacteria_sour_cream", 
        () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> PETRI_DISH_MILK_BACTERIA_WHEY = ITEMS.register("petri_dish_milk_bacteria_whey", 
        () -> new Item(new Item.Properties()));

    // Готовые продукты
    public static final RegistryObject<Item> YOGURT = ITEMS.register("yogurt", 
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(5)
                .saturationMod(0.6f)
                .build())
        ));

    public static final RegistryObject<Item> SOUR_CREAM = ITEMS.register("sour_cream", 
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.6f)
                .build())
        ));

    public static final RegistryObject<Item> WHEY = ITEMS.register("whey", 
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build())
        ));

    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough", 
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(0.3f)
                .build())
        ));
    
    public static final RegistryObject<Item> LEPESHKA = ITEMS.register("lepeshka", 
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(0.6f)
                .build())
        ));
    
    public static final RegistryObject<Item> COOKED_LEPESHKA = ITEMS.register("cooked_lepeshka", 
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.8f)
                .build())
        ));
    
    public static final RegistryObject<Item> SHAVERMA = ITEMS.register("shaverma", 
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(8)
                .saturationMod(1.0f)
                .build())
        ));

    public static final RegistryObject<Item> HEATED_MILK = ITEMS.register("heated_milk", 
        () -> new HeatedMilk());

    // Угольные предметы
    public static final RegistryObject<Item> COAL_SALT = ITEMS.register("coal_salt", 
        () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> RAW_COAL_MIXTURE = ITEMS.register("raw_coal_mixture", 
        () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> FOOD_COAL_SALT = ITEMS.register("food_coal_salt", 
        () -> new Item(new Item.Properties()));

    // Натертые продукты
    public static final RegistryObject<Item> GRATED_CARROT = ITEMS.register("grated_carrot", 
        () -> new Item(new Item.Properties()
            .stacksTo(64)
            .food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(0.3f)
                .build())));
    public static final RegistryObject<Item> KOREAN_CARROT = ITEMS.register("korean_carrot", 
        () -> new Item(new Item.Properties()
            .stacksTo(64)
            .food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build())));
        


    public static final RegistryObject<Item> GRATED_POTATO = ITEMS.register("grated_potato", 
        () -> new Item(new Item.Properties()
            .stacksTo(64)
            .food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.2f)
                .build())));

    // Логотип для креативной вкладки
    public static final RegistryObject<Item> LOGO = ITEMS.register("logo", 
        () -> new Item(new Item.Properties()));
    
    // Внутренний класс для нагретого молока
    public static class HeatedMilk extends Item {
        public HeatedMilk() {
            super(new Item.Properties()
                .food(new FoodProperties.Builder()
                    .nutrition(0)           
                    .saturationMod(0.0f)    
                    .build())
            );
        }
    
        @Override
        @Nonnull public UseAnim getUseAnimation(@Nonnull ItemStack stack) {
            return UseAnim.DRINK;
        }
    
        @Override
        public int getUseDuration(@Nonnull ItemStack stack) {
            return 32;
        }
    
        @Override
        @Nonnull
        public ItemStack finishUsingItem(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull LivingEntity entity) {
            if (entity instanceof Player player) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
            }
            return super.finishUsingItem(stack, level, entity);
        }
    }
}
