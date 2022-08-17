package ydzhao.weixin.tuisong.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ydzhao.weixin.tuisong.util.Pusher;
import ydzhao.weixin.tuisong.util.Template;

import java.util.List;

/**
 * 秦同学
 */
@Component
public class JobWorker {
    @Autowired
    Pusher pusher;
//    @Scheduled(cron = "*/5 * * * * ?")
//    public void goodMorning() {
//        pusher.push(openId, cityKey, Template.MorningTemplateId);
//    }

    @Scheduled(cron = "0 30 7 * * ?")
    public void goodMorning(){
        pusher.push(Template.MorningTemplateId);
    }

    @Scheduled(cron = "0 30 16 * * ?")
    public void goodAfternoon() {
        pusher.push(Template.AfternoonTemplateId);
    }

    @Scheduled(cron = "0 30 22 * * ?")
    public void goodEvening() {
        pusher.push(Template.EveningTemplateId);
    }
}
