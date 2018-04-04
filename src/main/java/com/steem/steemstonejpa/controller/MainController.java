package com.steem.steemstonejpa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.steem.steemstonejpa.common.SteemApi;
import com.steem.steemstonejpa.models.Notice;
import com.steem.steemstonejpa.repositories.NoticeRepository;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.exceptions.SteemCommunicationException;
import eu.bittrade.libs.steemj.exceptions.SteemResponseException;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
    private NoticeRepository noticeRepository;
	
	@RequestMapping("/hello") 
    public String hello(Model model, 
    		@RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        
        List<Notice> list = noticeRepository.findAll();
        System.out.println(list);
        
        Notice no = new Notice();
        no.setContent("content");
        no.setDelYn("N");
        no.setTitle("title!!");
        no.setRegDate("20180404");
        noticeRepository.save(no);
        
        list.add(no);
        try{
        	SteemJ steemApi = SteemApi.getInstance().getSteemJ();
            System.out.println(steemApi.getAccountCount());
            
            ArrayList<HashMap<String, String>> testList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> testMap = new HashMap<String, String>();
            testMap.put("TEST", "TESTDATA");
            
            testList.add(testMap);
            model.addAttribute("result", testList);
        }catch(SteemResponseException e){
        	logger.error("SteemResponseException.....................");
        	e.printStackTrace();
        }catch(SteemCommunicationException e){
        	logger.error("SteemCommunicationException.....................");
        	e.printStackTrace();
        }catch(Exception e){
        	logger.error("Other Exception.....................");
        	e.printStackTrace();
        }
        
        return "pages/index";
    }

}

