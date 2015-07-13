package kr.co.ipmall.controller.userController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ipmall.service.userService.UserService;
import kr.co.ipmall.vo.AuthInfo;
import kr.co.ipmall.vo.User;

@Controller
public class LoginController {
	Logger log = Logger.getLogger(this.getClass());
	
	/*
	@Resource(name = "authService")
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	*/
	
	@Resource(name = "userService")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value= "login.do" ,method = RequestMethod.GET)
	public ModelAndView form(LoginCommand loginCommand) {
		ModelAndView mv = new ModelAndView("/view/login/loginForm");
		return mv;
	}
	
	@RequestMapping(value="submit.do",method = RequestMethod.POST)
	public ModelAndView submit(LoginCommand loginCommand, Errors errors, HttpSession session){
		ModelAndView mv;
		User user;
		
		
		if(errors.hasErrors()){
			System.out.println("login submit error : " + errors);
			mv = new ModelAndView("/view/login/loginSuccess");
			return mv;
		}
			try {
				System.out.println("authenticate!!!");
				user = userService.authenticate(loginCommand.getEmail(), loginCommand.getPw());
				// session에 user 객체 저장
				session.setAttribute("userSession", user);
				mv = new ModelAndView("/view/index");
				return mv;
			} catch (Exception e) {
				errors.reject("idPasswordNotMatching");
				mv = new ModelAndView("/view/login/loginForm");
				return mv;
			}
	}

}
