package com.kyanite.deeperdarker.datagen.data.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public record DDChestLoot(HolderLookup.Provider registries) implements LootTableSubProvider {
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_BASEMENT = register("chests/ancient_temple_basement");
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_SECRET = register("chests/ancient_temple_secret");
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_STORAGE = register("chests/ancient_temple_storage");
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_FOUNTAIN = register("chests/ancient_temple_fountain");
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_APEX = register("chests/ancient_temple_apex");
    public static final ResourceKey<LootTable> CRYSTALLIZED_AMBER = register("chests/crystallized_amber");

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pOutput) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        pOutput.accept(ANCIENT_TEMPLE_BASEMENT, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(4, 6))
                .add(LootItem.lootTableItem(Blocks.SCULK).setWeight(32).apply(SetItemCountFunction.setCount(UniformGenerator.between(6, 8))))
                .add(LootItem.lootTableItem(Blocks.SOUL_SOIL).setWeight(31).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
                .add(LootItem.lootTableItem(DDItems.SOUL_DUST.get()).setWeight(31).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
                .add(LootItem.lootTableItem(Items.ECHO_SHARD).setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 7))))
                .add(LootItem.lootTableItem(DDItems.GRIME_BRICK.get()).setWeight(28).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 13))))
                .add(LootItem.lootTableItem(Items.NAME_TAG).setWeight(26))
                .add(LootItem.lootTableItem(DDItems.SCULK_BONE.get()).setWeight(25).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 7))))
                .add(LootItem.lootTableItem(Items.STRING).setWeight(20).apply(SetItemCountFunction.setCount(UniformGenerator.between(9, 16))))
                .add(LootItem.lootTableItem(DDBlocks.CRYSTALLIZED_AMBER.get()).setWeight(18).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5))))
                .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(16).apply(SetItemCountFunction.setCount(UniformGenerator.between(7, 14))))
                .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(13).apply(SetItemCountFunction.setCount(UniformGenerator.between(7, 12))))
                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
                .add(LootItem.lootTableItem(Items.BOOK).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).apply(EnchantRandomlyFunction.randomApplicableEnchantment(this.registries)))
                .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(Items.MUSIC_DISC_OTHERSIDE).setWeight(2))
//                .add(LootItem.lootTableItem(Items.BOOK).setWeight(1).apply(EnchantRandomlyFunction.randomEnchantment().withEnchantment(enchantments.getOrThrow(DDEnchantments.CATALYSIS))))
                .add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE.get()).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2))
                .add(LootItem.lootTableItem(Items.POTION).setWeight(10).apply(SetPotionFunction.setPotion(Potions.STRONG_STRENGTH)))
                .add(LootItem.lootTableItem(Items.IRON_LEGGINGS).setWeight(7).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(25, 35))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.5f))))
                .add(LootItem.lootTableItem(Items.IRON_SHOVEL).setWeight(7).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(15, 30))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.9f))))
                .add(LootItem.lootTableItem(Items.DIAMOND_BOOTS).setWeight(5).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(25, 40))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1f, 0.2f))))
                .add(LootItem.lootTableItem(Items.IRON_HOE).setWeight(5).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(20, 40))))
                .add(LootItem.lootTableItem(Items.DIAMOND_SWORD).setWeight(4).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 40))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.4f, 0.8f))))
                .add(LootItem.lootTableItem(Items.DIAMOND_HELMET).setWeight(3).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(35, 50))))
                .add(LootItem.lootTableItem(Items.DIAMOND_HOE).setWeight(3).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.9f))))
                .add(LootItem.lootTableItem(Items.DIAMOND_LEGGINGS).setWeight(3).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.15f, 0.4f))))
                .add(LootItem.lootTableItem(Items.DIAMOND_AXE).setWeight(2).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.7f))))
                .add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).setWeight(2).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))));
        pOutput.accept(ANCIENT_TEMPLE_SECRET, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3, 6))
                .add(LootItem.lootTableItem(Blocks.COBWEB).setWeight(97).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(Items.ECHO_SHARD).setWeight(29).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))).add(EmptyLootItem.emptyItem().setWeight(17))
                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))))
                .add(LootItem.lootTableItem(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE.get()).setWeight(1))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(DDItems.SCULK_TRANSMITTER.get()))));
        pOutput.accept(ANCIENT_TEMPLE_STORAGE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3, 5))
                .add(LootItem.lootTableItem(DDBlocks.SCULK_STONE.get()).setWeight(16).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                .add(LootItem.lootTableItem(Blocks.COBBLESTONE).setWeight(16).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 8))))
                .add(LootItem.lootTableItem(DDBlocks.ECHO_LOG.get()).setWeight(13).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 8))))
                .add(LootItem.lootTableItem(Items.AMETHYST_SHARD).setWeight(11).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                .add(LootItem.lootTableItem(Items.REDSTONE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                .add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8))))
                .add(LootItem.lootTableItem(Items.RAW_IRON).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 10))))
                .add(LootItem.lootTableItem(Items.RAW_COPPER).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 10))))
                .add(LootItem.lootTableItem(Items.RAW_GOLD).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 10))))
                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))));
        pOutput.accept(ANCIENT_TEMPLE_FOUNTAIN, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(4, 6))
                .add(LootItem.lootTableItem(Blocks.COBWEB).setWeight(33).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                .add(LootItem.lootTableItem(Items.STRING).setWeight(31).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 10))))
                .add(LootItem.lootTableItem(Blocks.COBBLESTONE).setWeight(28).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 8))))
                .add(LootItem.lootTableItem(Blocks.SCULK).setWeight(25).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 10))))
                .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(16).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 8))))
                .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(16).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                .add(LootItem.lootTableItem(Items.REDSTONE).setWeight(14).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 9))))
                .add(LootItem.lootTableItem(Items.RAW_COPPER).setWeight(13).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 10))))
                .add(LootItem.lootTableItem(DDItems.SOUL_DUST.get()).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5))))
                .add(LootItem.lootTableItem(Items.GOLD_NUGGET).setWeight(9).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 17))))
                .add(LootItem.lootTableItem(Items.QUARTZ).setWeight(9).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 7))))
                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(8).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                .add(LootItem.lootTableItem(Blocks.SCULK_SENSOR).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(Blocks.SCULK_CATALYST).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(Items.DIAMOND_SWORD).setWeight(1).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(20, 50))))
                .add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL.get()).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));
        pOutput.accept(ANCIENT_TEMPLE_APEX, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(5, 6))
                .add(LootItem.lootTableItem(Blocks.SCULK).setWeight(41).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 8))))
                .add(LootItem.lootTableItem(DDItems.SCULK_BONE.get()).setWeight(40).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6))))
                .add(LootItem.lootTableItem(Items.ECHO_SHARD).setWeight(40).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 9))))
                .add(LootItem.lootTableItem(DDItems.GRIME_BRICK.get()).setWeight(37).apply(SetItemCountFunction.setCount(UniformGenerator.between(7, 13))))
                .add(LootItem.lootTableItem(DDItems.GRIME_BALL.get()).setWeight(34).apply(SetItemCountFunction.setCount(UniformGenerator.between(8, 18))))
                .add(LootItem.lootTableItem(Blocks.TNT).setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 9))))
                .add(LootItem.lootTableItem(Items.FLINT).setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6))))
                .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(27).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 10))))
                .add(LootItem.lootTableItem(Items.QUARTZ).setWeight(22).apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 13))))
                .add(LootItem.lootTableItem(Items.REDSTONE).setWeight(18).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 12))))
                .add(LootItem.lootTableItem(Items.DISC_FRAGMENT_5).setWeight(17).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(17).apply(SetItemCountFunction.setCount(UniformGenerator.between(7, 19))))
                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(17).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8))))
                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 9))))
                .add(LootItem.lootTableItem(DDBlocks.CRYSTALLIZED_AMBER.get()).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(Blocks.SCULK_SENSOR).setWeight(12).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(Blocks.SCULK_CATALYST).setWeight(12).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                .add(LootItem.lootTableItem(Items.IRON_HELMET).setWeight(5).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 40))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.9f))))
                .add(LootItem.lootTableItem(Items.IRON_SWORD).setWeight(5).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 40))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.6f))))
                .add(LootItem.lootTableItem(Items.DIAMOND_BOOTS).setWeight(4).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.4f, 0.7f))))
                .add(LootItem.lootTableItem(Items.DIAMOND_HELMET).setWeight(4).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.8f, 1f))))
                .add(LootItem.lootTableItem(Items.BOOK).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).apply(EnchantRandomlyFunction.randomApplicableEnchantment(this.registries)))
                .add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).setWeight(2).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.6f, 0.9f))))
                .add(LootItem.lootTableItem(Items.DIAMOND_LEGGINGS).setWeight(2).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.6f, 0.8f))))
                .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(1).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.9f))))
                .add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE.get()).setWeight(1).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.9f))))));
        pOutput.accept(CRYSTALLIZED_AMBER, LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(8))
                .add(LootItem.lootTableItem(DDItems.SCULK_BONE.get()).setWeight(8))
                .add(LootItem.lootTableItem(DDItems.SOUL_DUST.get()).setWeight(8))
                .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(7))
                .add(LootItem.lootTableItem(Items.QUARTZ).setWeight(7))
                .add(LootItem.lootTableItem(Items.AMETHYST_SHARD).setWeight(5))
                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(4))
                .add(LootItem.lootTableItem(Items.IRON_BOOTS).setWeight(4))
                .add(LootItem.lootTableItem(Items.IRON_BOOTS).setWeight(3).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(20, 30))))
                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(2))
                .add(LootItem.lootTableItem(Items.DIAMOND_AXE))));
    }

    private static ResourceKey<LootTable> register(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, name));
    }
}
