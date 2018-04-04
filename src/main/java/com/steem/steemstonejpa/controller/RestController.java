package com.steem.steemstonejpa.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping(value="/hello2", method= RequestMethod.GET)
	public String test3() {
		return "success";
	}
}
