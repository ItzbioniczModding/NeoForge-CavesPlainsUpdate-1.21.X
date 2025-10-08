package net.itzbionicz.cavesplainsupdate.block;

import net.itzbionicz.cavesplainsupdate.CpuMod;
import net.itzbionicz.cavesplainsupdate.block.custom.ModRotatedPillarBlock;
import net.itzbionicz.cavesplainsupdate.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.swing.*;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CpuMod.MOD_ID);


   public static final DeferredBlock<Block> HOLLOW_PLANK = registerBlock("hollow_plank",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f)
                    .sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> HOLLOW_LOG = registerBlock("hollow_log",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    @Deprecated
    private static Block legacyStair(Block baseBlock) {
        return new StairBlock(baseBlock.defaultBlockState(), BlockBehaviour.Properties.ofLegacyCopy(baseBlock));
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
