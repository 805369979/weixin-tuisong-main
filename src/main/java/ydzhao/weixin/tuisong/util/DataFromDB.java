package ydzhao.weixin.tuisong.util;

import java.util.HashMap;
import java.util.Map;

public class DataFromDB {

    // 模拟从数据库中查找需要通知的女友信息
    public static Map<String, DateFromOpenId> getDataFromDB() {
        Map<String, DateFromOpenId> data = new HashMap<>();
        DateFromOpenId oqi0j5_vVGJhZAHJUN5ArH8hG0IQ = DateFromOpenId.builder().openId("oqi0j5_vVGJhZAHJUN5ArH8hG0IQ")
                .birthday("2023-07-21")
                .loveDate("2021-07-21")
                .city("101010100")
                .remainBirthday(AnniversariesDate.before("2023-07-21"))
                .hasLoveDate(AnniversariesDate.after("2021-07-21"))
                .build();
        data.put("oqi0j5_vVGJhZAHJUN5ArH8hG0IQ", oqi0j5_vVGJhZAHJUN5ArH8hG0IQ);

        DateFromOpenId oqi0j58uW5dZ0ym3UIsDbQMK9cEM = DateFromOpenId.builder().openId("oqi0j58uW5dZ0ym3UIsDbQMK9cEM")
                .birthday("2023-07-21")
                .loveDate("2021-07-21")
                .city("101010100")
                .remainBirthday(AnniversariesDate.before("2023-07-21"))
                .hasLoveDate(AnniversariesDate.after("2021-07-21"))
                .build();
        data.put("oqi0j58uW5dZ0ym3UIsDbQMK9cEM", oqi0j58uW5dZ0ym3UIsDbQMK9cEM);

        DateFromOpenId oqi0j5_XMyCOzWM8nMe_d_W2NVhY = DateFromOpenId.builder().openId("oqi0j5_XMyCOzWM8nMe-d-W2NVhY")
                .birthday("2023-07-21")
                .loveDate("2021-07-21")
                .city("101010100")
                .remainBirthday(AnniversariesDate.before("2023-07-21"))
                .hasLoveDate(AnniversariesDate.after("2021-07-21"))
                .build();
        data.put("oqi0j5_XMyCOzWM8nMe_d_W2NVhY", oqi0j5_XMyCOzWM8nMe_d_W2NVhY);
        return data;
    }

}
