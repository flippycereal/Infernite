package net.flippycereal.infernitemod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.flippycereal.infernitemod.Infernite;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class InferniteItems {

    public static Item INFERNITE_INGOT = registerItem("infernite_ingot",
            new Item(new FabricItemSettings()));

    //public static final Item INFERNITE_TOTEM = registerItem("infernite_totem",
    //new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));



    public static Item INFERNITE_SCYTHE = registerItem("infernite_scythe",
            new InferniteScytheItem(InferniteMaterial.INFERNITE, 7, -2.4f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Infernite.MOD_ID, name), item);
    }

    public static void registerInferniteItems() {
    }
}