package net.itzbionicz.cavesplainsupdate.block;

import net.itzbionicz.cavesplainsupdate.CpuMod;
import net.itzbionicz.cavesplainsupdate.block.custom.ModRotatedPillarBlock;
import net.itzbionicz.cavesplainsupdate.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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
    public static final DeferredBlock<Block> HOLLOW_WOOD = registerBlock("hollow_wood",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));


    public static final DeferredBlock<StairBlock> HOLLOW_STAIRS = registerBlock("hollow_stairs",
            () -> new StairBlock(ModBlocks.HOLLOW_PLANK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> HOLLOW_SLAB = registerBlock("hollow_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)));

    public static final DeferredBlock<PressurePlateBlock> HOLLOW_PRESSURE_PLATE = registerBlock("hollow_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)));
    public static final DeferredBlock<ButtonBlock> HOLLOW_BUTTON = registerBlock("hollow_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20,BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD).noCollission()));

    public static final DeferredBlock<FenceBlock> HOLLOW_FENCE = registerBlock("hollow_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceGateBlock> HOLLOW_FENCE_GATE = registerBlock("hollow_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)));

    public static final DeferredBlock<DoorBlock> HOLLOW_DOOR = registerBlock("hollow_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> HOLLOW_TRAPDOOR = registerBlock("hollow_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD).noOcclusion()));



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
