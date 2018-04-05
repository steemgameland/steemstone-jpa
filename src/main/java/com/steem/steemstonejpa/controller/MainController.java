package com.steem.steemstonejpa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steem.steemstonejpa.common.SteemApi;
import com.steem.steemstonejpa.models.Notice;
import com.steem.steemstonejpa.models.Unit;
import com.steem.steemstonejpa.repositories.NoticeRepository;
import com.steem.steemstonejpa.repositories.UnitRepository;

import eu.bittrade.libs.steemj.SteemJ;
import eu.bittrade.libs.steemj.exceptions.SteemCommunicationException;
import eu.bittrade.libs.steemj.exceptions.SteemResponseException;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
    private NoticeRepository noticeRepository;
	
	@Autowired
    private UnitRepository unitRepository;
	
	@RequestMapping("/unitinfo/{unit}")
	public @ResponseBody Unit unitinfo(Model model, @PathVariable("unit") String unit){
		return new Unit();
	}
	
	@RequestMapping("/hello") 
    public String hello(Model model, 
    		@RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        
        List<Notice> list = noticeRepository.findAll();
        System.out.println("notice : " + list);
        
        Notice no = new Notice();
        no.setContent("content");
        no.setDelYn("N");
        no.setTitle("title!!");
        no.setRegDate("20180404135959");
        noticeRepository.save(no);
        
        
        List<Unit> unitlist = unitRepository.findAll();
        System.out.println("unit List : " + unitlist);
        Unit unit = new Unit();
        unit.setAttackrange(1);
        unit.setAttacktype("M");
        unit.setBotytype("N");
        unit.setKind("O");
        unit.setLevel(1);
        unit.setLife(1);
        unit.setName("Grunt");
        unit.setPower(1);
        unit.setPrice(0.01f);
        unit.setSpecial("");
        unit.setSplash("N");
        unitRepository.save(unit);
        
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

