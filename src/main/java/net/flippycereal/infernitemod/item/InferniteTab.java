package net.flippycereal.infernitemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.flippycereal.infernitemod.Infernite;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class InferniteTab {
    public static final ItemGroup INFERNITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Infernite.MOD_ID, "infernite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.infernite"))
                    .icon(() -> new ItemStack(InferniteItems.INFERNITE_INGOT)).entries((displayContext, entries) -> {
                        entries.add(InferniteItems.INFERNITE_INGOT);
                        entries.add(InferniteItems.INFERNITE_SCYTHE);
                    }).build());


    public static void registerInferniteGroup() {
    }
}
