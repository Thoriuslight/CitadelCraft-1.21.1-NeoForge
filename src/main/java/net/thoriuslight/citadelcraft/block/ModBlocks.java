package net.thoriuslight.citadelcraft.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thoriuslight.citadelcraft.CitadelCraft;
import net.thoriuslight.citadelcraft.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CitadelCraft.MODID);

    public static final DeferredBlock<Block> COMBINE_TILE = registerBlock("combine_tile",
            ()-> new Block(BlockBehaviour.Properties.of().strength(10.F, 10.F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final DeferredBlock<Block> COMBINE_WALL = registerBlock("combine_wall",
            ()-> new Block(BlockBehaviour.Properties.of().strength(10.F, 10.F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
