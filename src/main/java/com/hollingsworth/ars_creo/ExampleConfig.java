package com.hollingsworth.ars_creo;

import com.hollingsworth.arsnouveau.api.RegistryHelper;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber
public class ExampleConfig {

    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.IntValue WHEEL_BASE_SPEED;
    public static ForgeConfigSpec.IntValue WHEEL_BONUS_SPEED;
    static {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        WHEEL_BASE_SPEED = SERVER_BUILDER.comment("Base speed of the wheel").defineInRange("wheelBaseSpeed", 16, 0, Integer.MAX_VALUE);
        WHEEL_BONUS_SPEED = SERVER_BUILDER.comment("Speed of the wheel with a gold block in front").defineInRange("wheelMaxSpeed", 24, 0, Integer.MAX_VALUE);

        SERVER_CONFIG = SERVER_BUILDER.build();
    }
    
}
