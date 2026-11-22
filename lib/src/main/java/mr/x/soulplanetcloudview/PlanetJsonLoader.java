package mr.x.soulplanetcloudview;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public final class PlanetJsonLoader {

    private PlanetJsonLoader() {
        // 禁止实例化
    }

    /**
     * 解析 JSON 数据
     *
     * 支持两种格式：
     *
     * 1. JSON 数组
     * [
     *   {
     *     "title": "源码共享",
     *     "description": "开发者聚集地",
     *     "match": "98%",
     *     "color": "#FFF0F076"
     *   }
     * ]
     *
     * 2. JSON 对象
     * {
     *   "data": [...]
     * }
     *
     * @param json JSON 字符串
     * @return SimpleLayoutManager 兼容的数据
     */
    public static ArrayList<HashMap<Integer, String>> parse(
            String json
    ) {

        if (json == null || json.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "JSON 数据不能为空"
            );
        }

        try {

            json = json.trim();

            JSONArray array;

            if (json.startsWith("[")) {

                array = new JSONArray(json);

            } else if (json.startsWith("{")) {

                JSONObject object = new JSONObject(json);

                if (!object.has("data")
                        || object.isNull("data")) {

                    throw new IllegalArgumentException(
                            "JSON 中缺少 data 数组"
                    );
                }

                array = object.getJSONArray("data");

            } else {

                throw new IllegalArgumentException(
                        "不支持的 JSON 格式"
                );
            }

            ArrayList<HashMap<Integer, String>> result =
                    new ArrayList<>();

            for (int i = 0; i < array.length(); i++) {

                JSONObject object = array.getJSONObject(i);

                HashMap<Integer, String> item =
                        new HashMap<>();

                item.put(1, object.optString("title", ""));
                item.put(2, object.optString("description", ""));
                item.put(3, object.optString("match", ""));
                item.put(4, object.optString("color", ""));

                result.add(item);
            }

            return result;

        } catch (Exception e) {

            throw new IllegalArgumentException(
                    "PlanetJsonLoader 解析失败："
                            + e.getMessage(),
                    e
            );
        }
    }
}
