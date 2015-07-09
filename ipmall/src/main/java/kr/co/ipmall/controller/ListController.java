package kr.co.ipmall.controller;

import javax.annotation.Resource;

import kr.co.ipmall.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ListController {

Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="userService")
	private UserService userService;
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(value="list.do")
    public ModelAndView detail() throws Exception{
    	ModelAndView mv = new ModelAndView("/view/list");
    	
    	return mv;
    }
	
}
