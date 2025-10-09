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

        blockItem(ModBlocks.HOLLOW_LOG);
        blockItem(ModBlocks.HOLLOW_WOOD);
        blockItem(ModBlocks.STRIPPED_HOLLOW_LOG);
        blockItem(ModBlocks.STRIPPED_HOLLOW_WOOD);
        blockWithitem(ModBlocks.HOLLOW_PLANK);
        stairsBlock(ModBlocks.HOLLOW_STAIRS.get(), blockTexture(ModBlocks.HOLLOW_PLANK.get()));
        slabBlock(ModBlocks.HOLLOW_SLAB.get(), blockTexture(ModBlocks.HOLLOW_PLANK.get()), blockTexture(ModBlocks.HOLLOW_PLANK.get()));
        buttonBlock(ModBlocks.HOLLOW_BUTTON.get(), blockTexture(ModBlocks.HOLLOW_PLANK.get()));
        pressurePlateBlock(ModBlocks.HOLLOW_PRESSURE_PLATE.get(), blockTexture(ModBlocks.HOLLOW_PLANK.get()));
        fenceBlock(ModBlocks.HOLLOW_FENCE.get(), blockTexture(ModBlocks.HOLLOW_PLANK.get()));
        fenceGateBlock(ModBlocks.HOLLOW_FENCE_GATE.get(), blockTexture(ModBlocks.HOLLOW_PLANK.get()));

        doorBlockWithRenderType(ModBlocks.HOLLOW_DOOR.get(), modLoc("block/hollow_door_bottom"), modLoc("block/hollow_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.HOLLOW_TRAPDOOR.get(), modLoc("block/hollow_trapdoor"), true,"cutout");

        blockItem(ModBlocks.HOLLOW_STAIRS);
        blockItem(ModBlocks.HOLLOW_SLAB);
        blockItem(ModBlocks.HOLLOW_PRESSURE_PLATE);
        blockItem(ModBlocks.HOLLOW_FENCE_GATE);
        blockItem(ModBlocks.HOLLOW_TRAPDOOR, "_bottom");

        logBlock(((RotatedPillarBlock)ModBlocks.HOLLOW_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.HOLLOW_WOOD.get()), blockTexture(ModBlocks.HOLLOW_LOG.get()), blockTexture(ModBlocks.HOLLOW_LOG.get()));
        logBlock(((RotatedPillarBlock)ModBlocks.STRIPPED_HOLLOW_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_HOLLOW_WOOD.get()), blockTexture(ModBlocks.STRIPPED_HOLLOW_LOG.get()), blockTexture(ModBlocks.STRIPPED_HOLLOW_LOG.get()));
    }

    private void blockWithitem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cpumod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cpumod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
