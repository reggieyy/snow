package com.reggie.snow.testkit;

import static java.text.MessageFormat.format;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.MapUtils;
import org.yaml.snakeyaml.Yaml;

/**
 * test http
 */
public class HttpKit {

    private static Map<String, String> appSettings;

    private static final String KEY_SERVER_PORT = "server:port";

    public static String apiURL(String relativeURL) {
        String port = getAppSettings().get(KEY_SERVER_PORT);
        return format("http://localhost:{0}/snow{1}", port, relativeURL);
    }

    public static String apiURL(String relativeURLTemplate, Object... args) {
        String relativeURL = format(relativeURLTemplate, args);
        return apiURL(relativeURL);
    }

    private static Map<String, String> getAppSettings() {
        if (appSettings == null) {
            loadApplicationSettings();
        }
        return appSettings;
    }

    private static void loadApplicationSettings() {
        appSettings = new HashMap<>();

        InputStream resourceAsStream = HttpKit.class.getClassLoader().getResourceAsStream("application.yml");
        Yaml yaml = new Yaml();
        Map<String, Map<String, Object>> values = (Map<String, Map<String, Object>>) yaml.load(resourceAsStream);
        if (MapUtils.isEmpty(values)) {
            return;
        }

        values.keySet().stream().filter(key -> key.equals("server")).forEach(key -> {
            Map<String, Object> subValues = values.get(key);
            subValues.keySet().stream().filter(subValueKey -> subValueKey.equals("port")).forEach(subValueKey -> {
                appSettings.put(KEY_SERVER_PORT, subValues.get(subValueKey).toString());
            });
        });
    }

}
