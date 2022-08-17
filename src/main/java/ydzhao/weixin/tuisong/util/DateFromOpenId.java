package ydzhao.weixin.tuisong.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Builder
@Data
public class DateFromOpenId {
    String openId;
    String city;
    // 恋爱
    String loveDate = "2022-08-10";
    // 领证
    String marryCertificate = "2024-03-19";
    // 结婚
    String marryDate = "2023-07-08";
    // 生日
    String birthday = "2023-07-21";
    // 在一起多久了
    Integer hasLoveDate;
    // 还剩多少天生日
    Integer remainBirthday;
}
