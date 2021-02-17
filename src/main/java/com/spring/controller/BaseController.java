package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
 
	@RequestMapping("/")
	  public String index() {
	    return "index";
	  }
	
	@RequestMapping("/trangchu")
	  public String content() {
	    return "content";
	  }
	
	@RequestMapping("/tap")
		public String tap() {
			return "chap";
		}
 
}