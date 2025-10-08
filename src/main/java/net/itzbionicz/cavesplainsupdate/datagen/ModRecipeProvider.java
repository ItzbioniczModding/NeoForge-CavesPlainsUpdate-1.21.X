package net.itzbionicz.cavesplainsupdate.datagen;

import net.itzbionicz.cavesplainsupdate.block.ModBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;

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
        .save(recipeOutput);

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
