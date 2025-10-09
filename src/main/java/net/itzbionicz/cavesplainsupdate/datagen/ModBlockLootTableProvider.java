package net.itzbionicz.cavesplainsupdate.datagen;

import net.itzbionicz.cavesplainsupdate.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
       dropSelf(ModBlocks.HOLLOW_PLANK.get());
       dropSelf(ModBlocks.HOLLOW_LOG.get());
       dropSelf(ModBlocks.HOLLOW_WOOD.get());
       dropSelf(ModBlocks.HOLLOW_STAIRS.get());
        add(ModBlocks.HOLLOW_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HOLLOW_SLAB.get()));
        dropSelf(ModBlocks.HOLLOW_PRESSURE_PLATE.get());
       dropSelf(ModBlocks.HOLLOW_BUTTON.get());
       dropSelf(ModBlocks.HOLLOW_FENCE.get());
       dropSelf(ModBlocks.HOLLOW_FENCE_GATE.get());
        add(ModBlocks.HOLLOW_DOOR.get(),
                block -> createDoorTable(ModBlocks.HOLLOW_DOOR.get()));
       dropSelf(ModBlocks.HOLLOW_TRAPDOOR.get());

        //add(ModBlocks.FARVINITE_ORE.get(),
                //block -> createOreDrop(ModBlocks.FARVINITE_ORE.get(), ModItems.FARVINITE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
