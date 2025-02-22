package com.tutuplay2222.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.tutuplay2222.russiancookingmod;
import com.tutuplay2222.items.moditems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = 
        DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, russiancookingmod.MODID);

    public static final RegistryObject<Codec<CoalSaltLootModifier>> COAL_SALT_MODIFIER = 
        LOOT_MODIFIER_SERIALIZERS.register("coal_salt_modifier", 
            () -> CoalSaltLootModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }

    public static class CoalSaltLootModifier extends LootModifier {
        private final float baseChance;
        private final float fortuneMultiplier;

        public static final Codec<CoalSaltLootModifier> CODEC = RecordCodecBuilder.create(instance -> 
            codecStart(instance)
                .and(Codec.FLOAT.fieldOf("baseChance").orElse(0.2f).forGetter(m -> m.baseChance))
                .and(Codec.FLOAT.fieldOf("fortuneMultiplier").orElse(0.05f).forGetter(m -> m.fortuneMultiplier))
                .apply(instance, CoalSaltLootModifier::new)
        );

        public CoalSaltLootModifier(LootItemCondition[] conditions, float baseChance, float fortuneMultiplier) {
            super(conditions);
            this.baseChance = baseChance;
            this.fortuneMultiplier = fortuneMultiplier;
        }

        @Nonnull
        @Override
        protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
            ResourceLocation lootTableId = context.getQueriedLootTableId();
            
            // Отладочная печать
            System.out.println("Loot Table ID: " + lootTableId);
            System.out.println("Fortune Level: " + context.getLootingModifier());

            // Проверяем лут-таблицы угольной руды
            if (lootTableId.toString().contains("coal_ore")) {
                
                // Расчет шанса с учетом уровня удачи
                float chance = baseChance;
                int fortuneLevel = context.getLootingModifier();
                chance += fortuneLevel * fortuneMultiplier;

                // Отладочная печать шанса
                System.out.println("Chance to drop Coal Salt: " + chance);
                System.out.println("Random value: " + context.getRandom().nextFloat());

                // Добавляем угольную соль с расчетным шансом
                if (context.getRandom().nextFloat() < chance) {
                    System.out.println("Coal Salt DROPPED!");
                    generatedLoot.add(new ItemStack(moditems.COAL_SALT.get()));
                }
            }
            
            return generatedLoot;
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC;
        }
    }
}