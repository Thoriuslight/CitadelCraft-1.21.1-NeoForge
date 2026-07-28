package net.thoriuslight.citadelcraft.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thoriuslight.citadelcraft.CitadelCraft;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CitadelCraft.MODID);

    public static final DeferredItem<Item> DARK_METAL_INGOT = ITEMS.register("dark_metal_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DARK_ENERGY_VIAL = ITEMS.register("dark_energy_vial",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
