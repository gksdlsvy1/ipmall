package kr.co.ipmall.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.co.ipmall.dao.RegisterRequest;
import kr.co.ipmall.dao.vo.User;
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
	
	@RequestMapping(value="sellerSignUpStep1.do")
    public ModelAndView sellerSignUpStep1() throws Exception{
    	ModelAndView mv = new ModelAndView("/view/register/sellerSignUpStep1");
    	
    	return mv;
    }
		
	@RequestMapping(value="sellerSignUpStep2.do" , method = RequestMethod.POST)
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
	
	@RequestMapping(value="sellerSignUpStep2.do" , method = RequestMethod.GET)
	public ModelAndView sellerSignUpStep2Get() throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/view/register/sellerSignUpStep1");
		return mv;
	}
	
	@RequestMapping(value="sellerSignUpStep3.do" , method = RequestMethod.POST)
	public ModelAndView sellerSignUpStep3(RegisterRequest req) throws Exception{
		ModelAndView mv;
		/// 나중에 이부분 판매자 회원 가입할때 error 처리 추가해야됨(userController 참조)
		try{
			// 객체 생성시 판매자, 활동 으로 저장
			req.setLevel(User.SELLER);
			req.setStatus(User.ACTIVE);
			userService.insertUser(req);
			mv = new ModelAndView("/view/index");
			return mv;
		} catch(kr.co.ipmall.model.exception.AlreadyExistingUserException ex) {
			mv = new ModelAndView("/view/register/sellerSignUpStep2");
			return mv;
		}
	}

}
