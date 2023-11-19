package net.flippycereal.infernitemod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.flippycereal.infernitemod.datagen.*;

public class InferniteDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(InferniteBlockTagProvider::new);
        pack.addProvider(InferniteItemTagProvider::new);
        pack.addProvider(InferniteLootTableProvider::new);
        pack.addProvider(InferniteModelProvider::new);
        pack.addProvider(InferniteRecipeProvider::new);
    }
}
