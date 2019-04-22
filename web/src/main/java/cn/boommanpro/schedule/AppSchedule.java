package cn.boommanpro.schedule;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author BoomMan
 */

/**
 * 在线 cron表达式生成: http://cron.qqe2.com/
 *
 * 但是业务有一些bug
 */
@Component
@Log4j2
public class AppSchedule {

    /**
     * 每周一 凌晨 清空排行榜
     */
    @Scheduled(cron = "0 10 1 ? *  MON")
    public void updateUserRank() {
        log.info("清空排行榜定时任务执行中: {} {}", LocalDateTime.now(), AppSchedule.class);
    }

    /**
     * 凌晨1点  留存定时任务
     **/
    @Scheduled(cron = "0 0 1 * * ?")
    public void statAccountRemain() {
        log.info("留存定时任务执行中: {} {}", LocalDateTime.now(), AppSchedule.class);
    }

    /**
     * 凌晨3点 清空用户开启宝箱次数
     **/
    @Scheduled(cron = "0 50 2 * * ?")
    public void clearAccountTreasureBox() {
        log.info("清空用户开启宝箱次数中: {} {}", LocalDateTime.now(), AppSchedule.class);
    }


    /**
     * 每周一 凌晨 1点20 同步上周参与战役系统
     **/
    @Scheduled(cron = "0 20 1 ? *  MON")
    public void syncLastWeekTakePartInCampaign() {
        log.info("同步上周参与战役系统: {} {}", LocalDateTime.now(), AppSchedule.class);
    }

    /**
     * 凌晨3点 同步连续参与战役
     **/
    @Scheduled(cron = "0 50 2 * * ?")
    public void syncAccountContinueTakePartInCampaign() {
        log.info("同步连续参与战役: {} {}", LocalDateTime.now(), AppSchedule.class);
    }

    /**
     * 凌晨3点 清空战役系统邀请
     **/
    @Scheduled(cron = "0 50 2 * * ?")
    public void clearCampaignInvited() {
        log.info("清空战役系统邀请: {} {}", LocalDateTime.now(), AppSchedule.class);
    }

    /**
     * 凌晨3点 清空战役系统邀请
     **/

    @Scheduled(cron = "0 50 2 * * ?")
    public void campaignInit() {
        log.info("清空战役系统邀请: {} {}", LocalDateTime.now(), AppSchedule.class);
    }




    /**
     * 凌晨3点 清空看视频次数  时间:每日: 0:20
     **/
    @Scheduled(cron = "0 20 0 * * ?")
    public void clear() {
        log.info("清空观看视频次数:  {},{}", LocalDateTime.now(), AppSchedule.class);
    }

    /**
     * @Description 战役系统轮转       时间: 每日: 1:10
     **/

    @Scheduled(cron = "0 10 1 * * ?")
    public void clearAllBoxAwardToMail() {
        log.info("战役系统轮转: {} {}", LocalDateTime.now(), AppSchedule.class);
    }


    /**
     * @Description 清空每日邀请人数   每日邀请宝箱记录  时间: 每日 0:10
     **/
    @Scheduled(cron = "0 10 0 * * ?")
    public void clearToDayInvite() {
        log.info("清空今日邀请及宝箱记录人数: {} {}", LocalDateTime.now(), AppSchedule.class);
    }


}
