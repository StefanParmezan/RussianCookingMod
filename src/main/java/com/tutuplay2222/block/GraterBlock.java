package com.tutuplay2222.block;

import com.tutuplay2222.items.moditems;
import com.tutuplay2222.sounds.ModSounds; // Правильный импорт
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class GraterBlock extends Block {
    public GraterBlock(Properties properties) {
        super(properties);
    }

    @Nonnull
    @NotNull
    @Override
    public InteractionResult use(
            @Nonnull BlockState state, 
            @Nonnull Level level, 
            @Nonnull BlockPos pos, 
            @Nonnull Player player, 
            @Nonnull InteractionHand hand, 
            @Nonnull BlockHitResult hit) {
        
        ItemStack heldItem = player.getItemInHand(hand);

        // Проверка на клиентской стороне
        if (level.isClientSide()) {
            if (heldItem.is(Items.CARROT) || heldItem.is(Items.POTATO)) {
                // Воспроизводим звук
                level.playSound(null, pos, ModSounds.GRATER_INTERACT.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            return InteractionResult.SUCCESS;
        }

        // Логика на серверной стороне
        if (heldItem.is(Items.CARROT)) {
            ItemStack gratedCarrot = new ItemStack(moditems.GRATED_CARROT.get());
            heldItem.shrink(1);
            
            if (!player.addItem(gratedCarrot)) {
                player.drop(gratedCarrot, false);
            }
            return InteractionResult.SUCCESS;
        }

        if (heldItem.is(Items.POTATO)) {
            ItemStack gratedPotato = new ItemStack(moditems.GRATED_POTATO.get());
            heldItem.shrink(1);
            
            if (!player.addItem(gratedPotato)) {
                player.drop(gratedPotato, false);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    public static Block get() {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}