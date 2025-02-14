package com.kyanite.deeperdarker;

import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class DeeperDarkerConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.DoubleValue FAKE_VASE_CHANCE = BUILDER.comment("Chance of a vase being fake", "Default: 0.16").defineInRange("fakeVaseChance", 0.16, 0, 1);
    private static final ModConfigSpec.DoubleValue STALKER_SPAWN_CHANCE = BUILDER.comment("Chance of a Stalker spawning when a fake vase is broken", "Default: 0.3125").defineInRange("stalkerSpawnChance", 0.3125, 0, 1);
    private static final ModConfigSpec.IntValue SOUL_ELYTRA_COOLDOWN = BUILDER.comment("Soul Elytra's boost cooldown in ticks. Set to -1 to disable boost", "Default: 600").defineInRange("soulElytraCooldown", 600, -1, 12000);
    private static final ModConfigSpec.BooleanValue WARDEN_HEART_PULSES = BUILDER.comment("Heart of the Deep beats like a heart", "Default: true").define("wardenHeartPulses", true);
    private static final ModConfigSpec.IntValue SNAPPER_DROP_LIMIT = BUILDER.comment("Limit the number of enchanted books a Sculk Snapper can drop", "Default: 8").defineInRange("snapperDropLimit", 8, 0, 32);
    private static final ModConfigSpec.IntValue OTHERSIDE_PORTAL_WIDTH = BUILDER.comment("Width of Otherside portal when generated by player", "Default: 6").defineInRange("othersidePortalWidth", 6, 2, 21);
    private static final ModConfigSpec.IntValue OTHERSIDE_PORTAL_HEIGHT = BUILDER.comment("Height of Otherside portal when generated by player", "Default: 3").defineInRange("othersidePortalHeight", 3, 3, 21);

    public static final ModConfigSpec SPEC = BUILDER.build();
    public static double fakeVaseChance;
    public static double stalkerSpawnChance;
    public static int soulElytraCooldown;
    public static boolean wardenHeartPulses;
    public static int snapperDropLimit;
    public static int othersidePortalWidth;
    public static int othersidePortalHeight;

    public static void loadConfigs(final ModConfigEvent event) {
        fakeVaseChance = FAKE_VASE_CHANCE.get();
        stalkerSpawnChance = STALKER_SPAWN_CHANCE.get();
        soulElytraCooldown = SOUL_ELYTRA_COOLDOWN.get();
        wardenHeartPulses = WARDEN_HEART_PULSES.get();
        snapperDropLimit = SNAPPER_DROP_LIMIT.get();
        othersidePortalWidth = OTHERSIDE_PORTAL_WIDTH.get();
        othersidePortalHeight = OTHERSIDE_PORTAL_HEIGHT.get();
    }
}
