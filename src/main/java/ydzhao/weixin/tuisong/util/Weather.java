package ydzhao.weixin.tuisong.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 秦同学
 */
public class Weather {

    public static JSONObject getWeather(String cityKey) {
        String result = null;
        JSONObject today = new JSONObject();
        try {
            result = HttpUtil.getUrl("http://wthrcdn.etouch.cn/weather_mini?citykey=" + cityKey);
            System.out.println(result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.getString("data") != null) {
                JSONArray arr = jsonObject.getJSONObject("data").getJSONArray("forecast");
                today = arr.getJSONObject(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return today;
    }

    public static void main(String[] args) {
        System.out.println(getWeather("温州"));
    }
}