package helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ConfigManager {
    private static ConfigManager mConfigManager;
    private final String configPath = "/config.yaml";
    private Map<String, Map<String, ?>> map;

    private ConfigManager() {
        Yaml config = new Yaml();
        InputStream iStream = this.getClass().getResourceAsStream(configPath);
        map = config.load(iStream);
    }

    public static ConfigManager getInstance() {
        if (mConfigManager == null) {
            mConfigManager = new ConfigManager();
        }
        return mConfigManager;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<String> interfaces(String interfaceName) {
        LinkedHashMap<String, ArrayList<String>> o = (LinkedHashMap<String, ArrayList<String>>) map.get("interfaces");
        ArrayList<String> oo = (ArrayList<String>) o.get(interfaceName);
        return oo;
    }

    @SuppressWarnings("unchecked")
    public LinkedHashMap<String, String> mappers() {
        return ((LinkedHashMap<String, String>) map.get("mappers"));
    }

    /**
     * This method returns related credentials which are stored inside credentials
     * key
     * in config file.
     * 
     * @param className class name for which credentials are stored.
     * @return HashMap of key/value in config file.
     */
    @SuppressWarnings("unchecked")
    public LinkedHashMap<String, String> credentials(String className) {
        return (LinkedHashMap<String, String>) ((LinkedHashMap<?, ?>) map.get("credentials")).get(className);
    }
}
