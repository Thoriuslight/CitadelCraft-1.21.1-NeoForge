package net.thoriuslight.citadelcraft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thoriuslight.citadelcraft.CitadelCraft;
import net.thoriuslight.citadelcraft.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CitadelCraft.MODID);

    public static final Supplier<CreativeModeTab> COMBINE_TAB = CREATIVE_MODE_TAB.register("combine_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.COMBINE_TILE.asItem()))
                    .title(Component.translatable("creativetab.citadelcraft.combine"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DARK_ENERGY_VIAL);
                        output.accept(ModItems.DARK_METAL_INGOT);
                        output.accept(ModBlocks.COMBINE_TILE);
                        output.accept(ModBlocks.COMBINE_WALL);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
