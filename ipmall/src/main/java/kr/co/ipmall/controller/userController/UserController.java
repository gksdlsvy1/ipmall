package kr.co.ipmall.controller.userController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.co.ipmall.dao.RegisterRequest;
import kr.co.ipmall.service.UserService;
import kr.co.ipmall.vo.AuthInfo;
import kr.co.ipmall.vo.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="userService")
	private UserService userService;
	
	private boolean isException = false;
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(value="details.do")
    public ModelAndView detail() throws Exception{
    	ModelAndView mv = new ModelAndView("/view/details");
    	
    	return mv;
    }
	
	@RequestMapping(value="index.do")
    public ModelAndView index() throws Exception{
    	ModelAndView mv = new ModelAndView("/view/index");
    	
    	return mv;
    }
	
	@RequestMapping(value="main.do")
    public ModelAndView main() throws Exception{
    	ModelAndView mv = new ModelAndView("/view/main");
    	
    	return mv;
    }
	
	@RequestMapping(value="customerSignUpStep1.do")
    public ModelAndView customerSignUpStep1() throws Exception{
    	ModelAndView mv = new ModelAndView("/view/register/customerSignUpStep1");
    	return mv;
    }
		
	@RequestMapping(value="customerSignUpStep2.do" , method = RequestMethod.POST)
	public ModelAndView customerSignUpStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) throws Exception{
		ModelAndView mv;
		if(!agree) {
			mv = new ModelAndView("/view/register/customerSignUpStep1");
			return mv;
		}
		mv = new ModelAndView("/view/register/customerSignUpStep2");
		return mv;
	}
	
	@RequestMapping(value = "customerSignUpStep2", method = RequestMethod.GET)
	public ModelAndView customerHandleStep2Get() throws Exception{
		ModelAndView mv = new ModelAndView("/view/register/customerSignUpStep2");
		return mv;
	}
	
	@RequestMapping(value="customerSignUpStep3.do" , method = RequestMethod.GET)
	public ModelAndView customerSignUpStep2Get() throws Exception{
		ModelAndView mv;
		if(isException) {
			isException = false;
			mv = new ModelAndView("/view/register/customerSignUpStep2.do");
		}
		mv = new ModelAndView("redirect:/view/register/customerSignUpStep2.do");
		return mv;
	}
	
	@RequestMapping(value="customerSignUpStep3.do" , method = RequestMethod.POST)
	public ModelAndView customerSignUpStep3(RegisterRequest req, Errors errors) throws Exception{
		new RegisterRequestValidator().validate(req, errors);
		ModelAndView mv;
		
		////////////////////
		if(errors.hasErrors()) {
			System.out.println(errors);
			mv = new ModelAndView("/view/register/customerSignUpStep2");
			return mv;
		}
		try{
			// 객체 생성시 구매자, 활동 으로 저장
			req.setLevel(User.CUSTOMER);
			req.setStatus(User.ACTIVE);
			userService.insertUser(req);
			mv = new ModelAndView("/view/index");
			return mv;
		} catch(kr.co.ipmall.model.exception.AlreadyExistingUserException ex){
			/*model.addAttribute("msg", "아이디 중복"); 
			model.addAttribute("url", "/ipmall/view/register/customerSignUpStep3.do");*/
			errors.rejectValue("email", "duplicate");
			mv = new ModelAndView("/view/register/customerSignUpStep2");
			return mv;
		}
	}
	
	@RequestMapping(value="deleteUser.do")
	public ModelAndView deleteUserInfo(HttpSession session) throws Exception{
		ModelAndView mv;
		User user = (User) session.getAttribute("userSession");
		userService.deleteUser(user.getEmail());
		session.invalidate();
		mv = new ModelAndView("/view/index");
		return mv;
	}
	
	@RequestMapping(value="changeUserInfo.do")
	public ModelAndView changeUserInfo(@ModelAttribute("req") User user, HttpSession session) throws Exception{
		ModelAndView mv;
		
		user = (User)session.getAttribute("userSession");
		mv = new ModelAndView("/view/edit/changeUserInfoForm");
		return mv;
	}
	
	@RequestMapping(value="submitChangeUserInfo.do")
	public ModelAndView submitUserInfo(RegisterRequest req, HttpSession session) throws Exception{
		ModelAndView mv;
		User user = (User) session.getAttribute("userSession");
		req.setEmail(user.getEmail());
		userService.updateUserInfo(req);
		mv = new ModelAndView("/view/index");
		return mv;
	}
	
	
	//////////////////////////////////////////////////
	
	/*
	@RequestMapping(value="/view/openBoardList.do")
    public ModelAndView openBoardList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("/view/boardList");
    	
    	List<Map<String,Object>> list = userService.selectBoardList(commandMap.getMap());
    	mv.addObject("list", list);
    	
    	return mv;
    }
	
	@RequestMapping(value="/view/openBoardWrite.do")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/view/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value="/view/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/view/openBoardList.do");
		
		userService.insertBoard(commandMap.getMap());
		
		return mv;
	}
	
	@RequestMapping(value="/view/openBoardDetail.do")
	public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/view/boardDetail");
		
		Map<String,Object> map = userService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map);
		
		return mv;
	}
	
	@RequestMapping(value="/view/openBoardUpdate.do")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/view/boardUpdate");
		
		Map<String,Object> map = userService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map);
		
		return mv;
	}
	
	@RequestMapping(value="/view/updateBoard.do")
	public ModelAndView updateBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/view/openBoardDetail.do");
		
		userService.updateBoard(commandMap.getMap());
		
		mv.addObject("IDX", commandMap.get("IDX"));
		return mv;
	}
	
	@RequestMapping(value="/view/deleteBoard.do")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/view/openBoardList.do");
		
		userService.deleteBoard(commandMap.getMap());
		
		return mv;
	}*/
}
