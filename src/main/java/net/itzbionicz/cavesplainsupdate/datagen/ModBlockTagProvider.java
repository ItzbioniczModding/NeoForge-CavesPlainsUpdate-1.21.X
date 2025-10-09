package net.itzbionicz.cavesplainsupdate.datagen;

import net.itzbionicz.cavesplainsupdate.CpuMod;
import net.itzbionicz.cavesplainsupdate.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CpuMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE);


        tag(BlockTags.MINEABLE_WITH_AXE)
        .add(ModBlocks.HOLLOW_LOG.get())
        .add(ModBlocks.HOLLOW_WOOD.get())
        .add(ModBlocks.STRIPPED_HOLLOW_LOG.get())
        .add(ModBlocks.STRIPPED_HOLLOW_WOOD.get())
        .add(ModBlocks.HOLLOW_PLANK.get())
        .add(ModBlocks.HOLLOW_STAIRS.get())
        .add(ModBlocks.HOLLOW_SLAB.get())
        .add(ModBlocks.HOLLOW_PRESSURE_PLATE.get())
        .add(ModBlocks.HOLLOW_BUTTON.get())
        .add(ModBlocks.HOLLOW_FENCE.get())
        .add(ModBlocks.HOLLOW_FENCE_GATE.get())
        .add(ModBlocks.HOLLOW_DOOR.get())
        .add(ModBlocks.HOLLOW_TRAPDOOR.get());


        tag(BlockTags.MINEABLE_WITH_SHOVEL);
                //.add(ModBlocks.SABBOTH_DIRT.get());

        tag(BlockTags.PLANKS)
                .add(ModBlocks.HOLLOW_PLANK.get());

        tag(BlockTags.FENCES).add(ModBlocks.HOLLOW_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.HOLLOW_FENCE_GATE.get());
    }
}
