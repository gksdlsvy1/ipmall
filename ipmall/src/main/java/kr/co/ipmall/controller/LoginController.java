package kr.co.ipmall.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.co.ipmall.dao.vo.AuthInfo;
import kr.co.ipmall.model.exception.IdPasswordNotMatchingException;
import kr.co.ipmall.service.AuthService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "authService")
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@RequestMapping(value= "login.do" ,method = RequestMethod.GET)
	public ModelAndView form(LoginCommand loginCommand) {
		ModelAndView mv = new ModelAndView("/view/login/loginForm");
		return mv;
	}
	
	@RequestMapping(value="submit.do",method = RequestMethod.POST)
	public ModelAndView submit(LoginCommand loginCommand, Errors errors, HttpSession session) throws Exception{
		new LoginCommandValidator().validate(loginCommand, errors);
		ModelAndView mv;
		AuthInfo authInfo;
		if(errors.hasErrors()){
			mv = new ModelAndView("/view/login/loginSuccess");
			return mv;
		}
			System.out.println("try");
			try {
				System.out.println("try");
				authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
				// 세션에 authInfo 저장
				session.setAttribute("authInfo", authInfo);
				mv = new ModelAndView("/view/index");
				return mv;
			} catch (Exception e) {
				errors.reject("idPasswordNotMatching");
				mv = new ModelAndView("/view/login/loginForm");
				return mv;
			}
	}

}
