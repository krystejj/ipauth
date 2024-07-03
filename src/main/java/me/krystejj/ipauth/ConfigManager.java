package me.krystejj.ipauth;

import org.quiltmc.loader.api.QuiltLoader;

import java.io.File;
import java.nio.file.Files;

public class ConfigManager {
    private final File configFile;
    public Config config;

    public ConfigManager() {
        config = new Config();
        configFile = new File(QuiltLoader.getConfigDir().toFile(), IPAuth.MOD_ID + ".json");
        try {
            if (configFile.exists()) {
                IPAuth.LOGGER.info("Loading configuration...");
                config = IPAuth.GSON.fromJson(Files.readString(configFile.toPath()), Config.class);
            } else {
                IPAuth.LOGGER.info("Creating new configuration...");
                saveConfig();
            }
        } catch (Exception exception) {
            IPAuth.LOGGER.error("Failed to load configuration.", exception);
        }
    }

    public void saveConfig() {
        try {
            Files.writeString(configFile.toPath(), config.serialize());
        } catch (Exception exception) {
            IPAuth.LOGGER.error("Failed to save configuration.", exception);
        }
    }
}
