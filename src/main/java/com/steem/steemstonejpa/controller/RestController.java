package com.steem.steemstonejpa.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.steem.steemstonejpa.models.Unit;
import com.steem.steemstonejpa.repositories.UnitRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
    private UnitRepository unitRepository;
	
	@RequestMapping("/unitname/{name}")
	public @ResponseBody List<Unit> unitinfo(@PathVariable("name") String name){
//		List<Unit> list = unitRepository.findByName(name);
		List<Unit> list = unitRepository.findByNameIgnoreCase(name);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/unitlevel/{level}")
	public @ResponseBody List<Unit> unitinfo(@PathVariable("level") int level){
		List<Unit> list = unitRepository.findByLevel(level);
		System.out.println(list);
		return list;
	}
}
