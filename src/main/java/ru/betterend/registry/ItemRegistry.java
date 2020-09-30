package ru.betterend.registry;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

import ru.betterend.BetterEnd;

public class ItemRegistry {
	private static final List<Item> MOD_BLOCKS = Lists.newArrayList();
	private static final List<Item> MOD_ITEMS = Lists.newArrayList();
	
	public final static Item ENDER_DUST = registerItem("ender_dust", new Item((new Item.Settings()).group(ItemGroup.MATERIALS)));
	public final static Item TERMINITE_INGOT = registerItem("terminite_ingot", new Item((new Item.Settings()).group(ItemGroup.MATERIALS)));
	public final static Item AETERNIUM_INGOT = registerItem("aeternium_ingot", new Item((new Item.Settings()).group(ItemGroup.MATERIALS)));

	protected static Item registerItem(String name, Item item) {
		if (item != Items.AIR) {
			Registry.register(Registry.ITEM, BetterEnd.getResId(name), item);
			if (item instanceof BlockItem)
				MOD_BLOCKS.add(item);
			else
				MOD_ITEMS.add(item);
		}
		return item;
	}

	public static void register() {}
	
	public static List<Item> getModBlocks() {
		return MOD_BLOCKS;
	}

	public static List<Item> getModItems() {
		return MOD_ITEMS;
	}
}
