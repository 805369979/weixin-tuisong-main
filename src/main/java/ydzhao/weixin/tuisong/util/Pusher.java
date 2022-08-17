package ydzhao.weixin.tuisong.util;

import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 秦同学
 */
@Component
public class Pusher {

    @Autowired
    WxMpService wxMpService;

    // 推送门面函数
    public void push(String templateId) {
        // 第一步： 获取到数据库里面存储的信息
        Map<String, DateFromOpenId> dataFromDB = DataFromDB.getDataFromDB();

        //第二步： 推送消息设置
        List<WxMpTemplateMessage> messages = getWxMpTemplateMessages(templateId, dataFromDB);

        // 第三步： 推送消息
        sendMessage(messages);
    }

    private void sendMessage(List<WxMpTemplateMessage> messages) {
        messages.forEach(message -> {
            try {
                wxMpService.getTemplateMsgService().sendTemplateMsg(message);
            } catch (Exception e) {
                System.out.println("推送失败：" + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private List<WxMpTemplateMessage> getWxMpTemplateMessages(String templateId, Map<String, DateFromOpenId> dataFromDB) {
        List<WxMpTemplateMessage> messages = new ArrayList<>(dataFromDB.size());
        dataFromDB.forEach((openId, dateFromOpenId)-> {
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().toUser(dateFromOpenId.getOpenId()).templateId(templateId)
                    //.url("https://30paotui.com/")//点击模版消息要访问的网址
                    .build();
            JSONObject todayWeather = Weather.getWeather(dateFromOpenId.getCity());
            // 填充需要给女朋友发送的信息
            fixNoticeInfo(templateMessage, todayWeather,dateFromOpenId);
            messages.add(templateMessage);
        });
        return messages;
    }

    private static void fixNoticeInfo(WxMpTemplateMessage templateMessage, JSONObject todayWeather,DateFromOpenId dateFromOpenId) {
        LocalDate now = LocalDate.now();
        templateMessage.addData(new WxMpTemplateData("riqi", now.toString().substring(0, now.toString().length() - 3) + " "
                + todayWeather.getString("date"), "#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi", todayWeather.getString("type"), "#173177"));
        templateMessage.addData(new WxMpTemplateData("low", todayWeather.getString("low").substring(3), "#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("high", todayWeather.getString("high").substring(3), "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("lianai", dateFromOpenId.getHasLoveDate() + "", "#FF1493"));
        templateMessage.addData(new WxMpTemplateData("shengri", dateFromOpenId.getRemainBirthday() + "", "#FFA500"));
        templateMessage.addData(new WxMpTemplateData("jinju", CaiHongPi.getJinJu() + "", "#00ccff"));
        templateMessage.addData(new WxMpTemplateData("caihongpi", CaiHongPi.getCaiHongPi(), "#ff0000"));
        // 特殊纪念日备注
        String beizhu = "";
        if (dateFromOpenId.getMarryDate() != null && AnniversariesDate.after(dateFromOpenId.getMarryDate()) % 365 == 0) {
            beizhu = "今天是结婚纪念日！";
        }
        if (dateFromOpenId.getLoveDate() != null && AnniversariesDate.after(dateFromOpenId.getLoveDate()) % 365 == 0) {
            beizhu = "今天是恋爱纪念日！";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu", beizhu, "#FF0000"));
    }
}
