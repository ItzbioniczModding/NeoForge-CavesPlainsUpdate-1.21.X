package net.itzbionicz.cavesplainsupdate.datagen;

import net.itzbionicz.cavesplainsupdate.block.ModBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;

import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //List<ItemLike> FARVINITE_SMELTABLES = List.of(ModItems.FARVINITE);

        // -------------------------------------------------------------------------------------------------------------------------------

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.HOLLOW_PLANK.get(), 4)
                .requires(ModBlocks.HOLLOW_LOG)
        .unlockedBy("has_hollow_log", has(ModBlocks.HOLLOW_LOG))
                .save(recipeOutput, "cpumod:hollow_planks_from_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.HOLLOW_PLANK.get(), 4)
                .requires(ModBlocks.HOLLOW_WOOD)
                .unlockedBy("has_hollow_wood", has(ModBlocks.HOLLOW_WOOD))
                .save(recipeOutput, "cpumod:hollow_planks_from_wood");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HOLLOW_WOOD.get(),4)
                .pattern("LL")
                .pattern("LL")
                .define('L', ModBlocks.HOLLOW_LOG.get())
                .unlockedBy("has_hollow_log", has(ModBlocks.HOLLOW_LOG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIPPED_HOLLOW_WOOD.get(),4)
                .pattern("LL")
                .pattern("LL")
                .define('L', ModBlocks.STRIPPED_HOLLOW_LOG.get())
                .unlockedBy("has_stripped_hollow_log", has(ModBlocks.STRIPPED_HOLLOW_LOG))
                .save(recipeOutput);


        stairBuilder(ModBlocks.HOLLOW_STAIRS.get(), Ingredient.of(ModBlocks.HOLLOW_PLANK)).group("hollow")
                .unlockedBy("has_hollow_planks", has(ModBlocks.HOLLOW_PLANK)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HOLLOW_SLAB.get(), ModBlocks.HOLLOW_PLANK.get());


        buttonBuilder(ModBlocks.HOLLOW_BUTTON.get(), Ingredient.of(ModBlocks.HOLLOW_PLANK.get())).group("hollow")
                .unlockedBy("has_hollow_planks", has(ModBlocks.HOLLOW_PLANK.get())).save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.HOLLOW_PRESSURE_PLATE.get(), ModBlocks.HOLLOW_PLANK.get());


        fenceBuilder(ModBlocks.HOLLOW_FENCE.get(), Ingredient.of(ModBlocks.HOLLOW_PLANK.get())).group("hollow")
                .unlockedBy("has_hollow_planks", has(ModBlocks.HOLLOW_PLANK.get())).save(recipeOutput);

        fenceGateBuilder(ModBlocks.HOLLOW_FENCE_GATE.get(), Ingredient.of(ModBlocks.HOLLOW_PLANK.get())).group("hollow")
                .unlockedBy("has_hollow_planks", has(ModBlocks.HOLLOW_PLANK.get())).save(recipeOutput);

        doorBuilder(ModBlocks.HOLLOW_DOOR.get(), Ingredient.of(ModBlocks.HOLLOW_PLANK.get())).group("hollow")
                .unlockedBy("has_hollow_planks", has(ModBlocks.HOLLOW_PLANK.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.HOLLOW_TRAPDOOR.get(), Ingredient.of(ModBlocks.HOLLOW_PLANK.get())).group("hollow")
                .unlockedBy("has_hollow_planks", has(ModBlocks.HOLLOW_PLANK.get())).save(recipeOutput);

        //ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FARVINITE_INGOT.get())
               // .pattern("NNN")
               // .pattern("NNN")
               // .pattern("NNN")
               // .define('N', ModItems.FARVINITE_NUGGET.get())
               // .unlockedBy("has_farvinite_nuggets", has(ModItems.FARVINITE_NUGGET))
                //.save(recipeOutput);

        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FARVINITE_NUGGET.get(), 9)
                //.requires(ModItems.FARVINITE_INGOT)
                //.unlockedBy("has_farvinite_ingot", has(ModItems.FARVINITE_INGOT))
                //.save(recipeOutput);



// -------------------------------------------------------------------------------------------------------------------------------
        //oreSmelting(recipeOutput, FARVINITE_SMELTABLES, RecipeCategory.MISC, ModItems.FARVINITE_INGOT.get(), 0.25f, 200, "farvinite");
       // oreBlasting(recipeOutput, FARVINITE_SMELTABLES, RecipeCategory.MISC, ModItems.FARVINITE_INGOT.get(), 0.25f, 100, "farvinite");


    }
}
