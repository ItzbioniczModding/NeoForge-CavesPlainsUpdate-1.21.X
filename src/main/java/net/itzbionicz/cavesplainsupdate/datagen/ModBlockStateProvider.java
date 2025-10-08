package net.itzbionicz.cavesplainsupdate.datagen;

import net.itzbionicz.cavesplainsupdate.CpuMod;
import net.itzbionicz.cavesplainsupdate.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CpuMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithitem(ModBlocks.HOLLOW_PLANK);

        blockItem(ModBlocks.HOLLOW_LOG);
        logBlock(((RotatedPillarBlock) ModBlocks.HOLLOW_LOG.get()));



    }

    private void blockWithitem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tgeternal:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tgeternal:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
