package com.demo.xianghuan.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuartzService {

    private static  final Logger log = LoggerFactory.getLogger(QuartzService.class);
    //    每分钟启动
    @Scheduled(cron = "0 0/1 * * * ?")
    public void timerToNow(){
        log.info("now time:{}" ,System.currentTimeMillis());
    }

}
