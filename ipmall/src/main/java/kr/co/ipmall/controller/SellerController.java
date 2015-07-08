package kr.co.ipmall.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.co.ipmall.dao.RegisterRequest;
import kr.co.ipmall.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SellerController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="userService")
	private UserService userService;
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(value="/view/register/sellerSignUpStep1.do")
    public ModelAndView sellerSignUpStep1() throws Exception{
    	ModelAndView mv = new ModelAndView("/view/register/sellerSignUpStep1");
    	
    	return mv;
    }
		
	@RequestMapping(value="/view/register/sellerSignUpStep2.do" , method = RequestMethod.POST)
	public ModelAndView sellerSignUpStep2(HttpServletRequest request) throws Exception{
		String agreeParam = request.getParameter("agree");
		ModelAndView mv;
		if(agreeParam == null || !agreeParam.equals("true")) {
			mv = new ModelAndView("/view/register/sellerSignUpStep1");
			return mv;
		}
		mv = new ModelAndView("/view/register/sellerSignUpStep2");
		return mv;
	}
	
	@RequestMapping(value="/view/register/sellerSignUpStep2.do" , method = RequestMethod.GET)
	public ModelAndView sellerSignUpStep2Get() throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/view/register/sellerSignUpStep1");
		return mv;
	}
	
	@RequestMapping(value="/view/register/sellerSignUpStep3.do" , method = RequestMethod.POST)
	public ModelAndView sellerSignUpStep3(RegisterRequest req) throws Exception{
		ModelAndView mv;
		try{
			System.out.println(req.getEmail());
			userService.insertUser(req);
			mv = new ModelAndView("/view/register/sellerSignUpStep3");
			return mv;
		} catch(kr.co.ipmall.model.exception.AlreadyExistingUserException ex) {
			mv = new ModelAndView("/view/register/sellerSignUpStep2");
			return mv;
		}
	}

}
