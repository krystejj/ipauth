package me.krystejj.ipauth;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.server.DedicatedServerModInitializer;
import org.quiltmc.qsl.networking.api.ServerPlayConnectionEvents;

public class IPAuth implements DedicatedServerModInitializer {
    public static final String MOD_ID = "ipauth";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Gson GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();

    @Override
    public void onInitializeServer(ModContainer mod) {
        ConfigManager configManager = new ConfigManager();
        Authorizer authorizer = new Authorizer(configManager);
        new CommandHandler(authorizer);
        ServerPlayConnectionEvents.INIT.register((handler, server) -> {
            Feedback feedback = authorizer.isAuthorized(handler.getPlayer());
            if (!feedback.ok()) {
                handler.disconnect(feedback.getTextOfMessage());
            }
        });
        LOGGER.info("{} Initialized", mod.metadata().name());
    }
}
