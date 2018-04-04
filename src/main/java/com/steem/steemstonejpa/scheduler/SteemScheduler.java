package com.steem.steemstonejpa.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.steem.steemstonejpa.enums.Camp;
import com.steem.steemstonejpa.interfaces.SteemOrder;

@Component
public class SteemScheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(SteemScheduler.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	
	@Scheduled(cron = "*/5 * * * * *")
	public void chkVoter(){
		logger.info("chkVoter start!!************************");
		SteemOrder steemOrder = new SteemOrder();
		steemOrder.addGold();
		logger.info("chkVoter end!!************************");
	}
	
	@Scheduled(cron = "*/10 * * * * *")
	public void crtHumanPosting(){
		logger.info("crtPosting start!!************************");
		SteemOrder steemOrder = new SteemOrder();
		steemOrder.gamePosting(Camp.HUMAN);
		logger.info("crtPosting end!!************************");
	}
	
	@Scheduled(cron = "*/20 * * * * *")
	public void crtOrcPosting(){
		logger.info("crtPosting start!!************************");
		SteemOrder steemOrder = new SteemOrder();
		steemOrder.gamePosting(Camp.ORC);
		logger.info("crtPosting end!!************************");
	}
	
	@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        logger.info("The time is now {}", dateFormat.format(new Date()));
    }
}

//
//function checkComment(kind){
//    var param = new Array();
//    param.push({kind:kind});
//
//    requesthandler('LST-STONE-GETNOTFINISHPOST', param, function(err, val1){
//        if(err){
//        
//        } else {
//            if(val1.length == 0) return;
//            // console.log(val1);
//            var permlink = val1[0].permlink;
//            
//            // get voter list
//            steem.api.getContentReplies(author, permlink, function(err, result) {
//                if(err){
//                    
//                } else {
//                    // console.log(result);
//                    forEach(result, function(value, index, arr) {
//                        console.log(value);
//                        var orderPermlink = value.permlink;
//                        var orderAccount = value.author;
//                        var body = value.body.split('\n');
//                        console.log(body);
//
//                        for(var i=0; i<body.length; i++){
//                            var line = body[i];
//                            var split = line.split(' ');
//                            
//                            if(split.length == 0) return;
//                            // 명령어가 포함되는 경우만 가져온다.
//                            if(Object.keys(Orders).indexOf(split[0].toUpperCase()) > -1){
//                                console.log(split);
//                                orderProcess(split);
//                            }
//                        }
//                    }, callback);
//                }
//            });
//        }
//    });
//}