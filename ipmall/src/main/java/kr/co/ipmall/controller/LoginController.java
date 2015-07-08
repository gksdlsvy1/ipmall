package kr.co.ipmall.controller;

import javax.annotation.Resource;

import kr.co.ipmall.dao.vo.AuthInfo;
import kr.co.ipmall.model.exception.IdPasswordNotMatchingException;
import kr.co.ipmall.service.AuthService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource(name = "authService")
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(LoginCommand loginCommand) {
		ModelAndView mv = new ModelAndView("/view/login/loginForm");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(LoginCommand loginCommand, Errors errors) {
		new LoginCommandValidator().validate(loginCommand, errors);
		ModelAndView mv;
		if(errors.hasErrors()) {
			mv = new ModelAndView("/view/login/loginForm");
			return mv;
		}
		try{
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			
			// 세션에 authInfo 저장해야 됨
			mv = new ModelAndView("/view/login/loginSuccess");
			return mv;
		}catch(IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			mv = new ModelAndView("/view/login/loginForm");
			return mv;
		}
	}

}
