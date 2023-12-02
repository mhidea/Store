package helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class ConfigManager {
    private static ConfigManager mConfigManager;
    private final String configPath = "../config.yaml";
    private Map<String, Object> map;

    private ConfigManager() {
        Yaml config = new Yaml();
        InputStream is = this.getClass().getResourceAsStream(configPath);
        map = config.load(is);
    }

    public static ConfigManager getInstance() {
        if (mConfigManager == null) {
            mConfigManager = new ConfigManager();
        }
        return mConfigManager;
    }

    public ArrayList<String> interfaces(String interfaceName) {
        return (ArrayList<String>) ((Map) map.get("interfaces")).get(interfaceName);
    }

    public HashMap credentials(String key) {

        return (HashMap) ((Map) map.get("credentials")).get(key);
    }
}
