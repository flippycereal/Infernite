package net.flippycereal.infernitemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.flippycereal.infernitemod.item.InferniteItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class InferniteRecipeProvider extends FabricRecipeProvider {
    public InferniteRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.MAGMA_BLOCK),
                Ingredient.ofItems(Items.NETHERITE_INGOT),
                Ingredient.ofItems(Items.MAGMA_CREAM),
                RecipeCategory.MISC, InferniteItems.INFERNITE_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(InferniteItems.INFERNITE_INGOT)));
    }
}
