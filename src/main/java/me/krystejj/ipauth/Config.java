package me.krystejj.ipauth;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Config {
    public boolean autoAuth;
    public boolean useUuid;
    public Map<String, Set<String>> authorized;

    public Config() {
        autoAuth = false;
        useUuid = true;
        authorized = new HashMap<>();
    }

    public String serialize() {
        return IPAuth.GSON.toJson(this, Config.class);
    }
}
