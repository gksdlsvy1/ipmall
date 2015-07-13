package kr.co.ipmall.controller.userController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.co.ipmall.service.userService.UserService;
import kr.co.ipmall.vo.RegisterRequest;
import kr.co.ipmall.vo.Seller;
import kr.co.ipmall.vo.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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
    public ModelAndView sellerSignUpStep1(){
    	ModelAndView mv = new ModelAndView("/view/register/sellerSignUpStep1");
    	
    	return mv;
    }
		
	// 동의 체크 누르지 않으면 진행 안됨
	@RequestMapping(value="sellerSignUpStep2.do" , method = RequestMethod.POST)
	public ModelAndView sellerSignUpStep2(HttpServletRequest request){
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
	public ModelAndView sellerSignUpStep2Get(){
		ModelAndView mv = new ModelAndView("redirect:/view/register/sellerSignUpStep1");
		return mv;
	}
	
	@RequestMapping(value="sellerSignUpStep3.do" , method = RequestMethod.POST)
	public ModelAndView sellerSignUpStep3(Seller seller, Errors errors) throws Exception{
		new RegisterRequestValidator().validate(seller, errors);
		ModelAndView mv;
		/// 나중에 이부분 판매자 회원 가입할때 error 처리 추가해야됨(userController 참조)
		if(errors.hasErrors()) {
			System.out.println(errors);
			mv = new ModelAndView("/view/register/sellerSignUpStep2");
			return mv;
		}
		try{
			// 객체 생성시 판매자, 활동 으로 저장
			seller.setLevel(User.SELLER);
			seller.setStatus(User.ACTIVE);
			
			userService.insertUser(seller);
			mv = new ModelAndView("/view/index");
			return mv;
		} catch(kr.co.ipmall.model.exception.AlreadyExistingUserException ex) {
			errors.rejectValue("email", "duplicate");
			mv = new ModelAndView("/view/register/sellerSignUpStep2");
			return mv;
		}
	}

}
