package utils;

import com.google.gson.Gson;

public class JsonUtil {
    private static final Gson GSON = new Gson();

    private JsonUtil() {

    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        return GSON.fromJson(jsonStr, clazz);
    }

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }
}
