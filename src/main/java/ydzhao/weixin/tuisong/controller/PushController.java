package ydzhao.weixin.tuisong.controller;

/**
 * 秦同学
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ydzhao.weixin.tuisong.job.JobWorker;
import ydzhao.weixin.tuisong.util.Pusher;
import ydzhao.weixin.tuisong.util.Template;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
public class PushController {

    @Autowired
    Pusher pusher;
    @Autowired
    JobWorker jobWorker;

    /**
     * 微信测试账号推送
     *
     */
    @GetMapping("/push")
    public void push(String city) {
//        pusher.push(Arrays.asList(mxp),"温州", Template.MorningTemplateId);
        jobWorker.goodMorning();
    }

    /**
     * 微信测试账号推送
     * */
//    @GetMapping("/push/zyd")
//    public void pushZyd() {
//        Pusher.push(zyd);
//    }


//    /**
//     * 微信测试账号推送
//     * */
//    @GetMapping("/push/{id}")
//    public void pushId(@PathVariable("id") String id) {
//        Pusher.push(id);
//    }
}