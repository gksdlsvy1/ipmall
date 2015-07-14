package kr.co.ipmall.controller.userController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.co.ipmall.service.inventoryService.InventoryService;
import kr.co.ipmall.service.userService.UserService;
import kr.co.ipmall.vo.AuthInfo;
import kr.co.ipmall.vo.Customer;
import kr.co.ipmall.vo.RegisterRequest;
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

	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "inventoryService")
	private InventoryService inventoryService;

	private boolean isException = false;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "customerSignUpStep1.do")
	public ModelAndView customerSignUpStep1() {
		ModelAndView mv = new ModelAndView("/view/register/customerSignUpStep1");
		return mv;
	}

	// 동의 체크하지 않으면 넘어가지 않음
	@RequestMapping(value = "customerSignUpStep2.do", method = RequestMethod.POST)
	public ModelAndView customerSignUpStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		ModelAndView mv;
		if (!agree) {
			mv = new ModelAndView("/view/register/customerSignUpStep1");
			return mv;
		}
		mv = new ModelAndView("/view/register/customerSignUpStep2");
		return mv;
	}

	@RequestMapping(value = "customerSignUpStep2", method = RequestMethod.GET)
	public ModelAndView customerHandleStep2Get() {
		ModelAndView mv = new ModelAndView("/view/register/customerSignUpStep2");
		return mv;
	}

	@RequestMapping(value = "customerSignUpStep3.do", method = RequestMethod.GET)
	public ModelAndView customerSignUpStep2Get() {
		ModelAndView mv;
		if (isException) {
			isException = false;
			mv = new ModelAndView("/view/register/customerSignUpStep2.do");
		}
		mv = new ModelAndView("redirect:/view/register/customerSignUpStep2.do");
		return mv;
	}

	@RequestMapping(value = "customerSignUpStep3.do", method = RequestMethod.POST)
	public ModelAndView customerSignUpStep3(Customer customer, Errors errors)
			throws Exception {
		new RegisterRequestValidator().validate(customer, errors);
		ModelAndView mv;
		int userNo;

		// //////////////////
		if (errors.hasErrors()) {
			System.out.println(errors);
			mv = new ModelAndView("/view/register/customerSignUpStep2");
			return mv;
		}
		try {
			// 객체 생성시 구매자, 활동 으로 저장
			customer.setLevel(User.CUSTOMER);
			customer.setStatus(User.ACTIVE);

			userService.insertUser(customer);
			userNo = userService.selectUserNo();
			inventoryService.createInventory(customer.getCustomer_no());
			mv = new ModelAndView("/view/index");
			return mv;
		} catch (kr.co.ipmall.model.exception.AlreadyExistingUserException ex) {
			/*
			 * model.addAttribute("msg", "아이디 중복"); model.addAttribute("url",
			 * "/ipmall/view/register/customerSignUpStep3.do");
			 */
			errors.rejectValue("email", "duplicate");
			mv = new ModelAndView("/view/register/customerSignUpStep2");
			return mv;
		}
	}

	@RequestMapping(value = "deleteUser.do")
	public ModelAndView deleteUserInfo(HttpSession session) {
		ModelAndView mv;

		try {
			User user = (User) session.getAttribute("userSession");
			userService.deleteUser(user.getEmail());
			session.invalidate();
		} catch (Exception e) {
			log.error(e);
		}

		mv = new ModelAndView("/view/index");
		return mv;
	}

	@RequestMapping(value = "changeUserInfo.do")
	public ModelAndView changeUserInfo(HttpSession session) {
		ModelAndView mv;
		try {
			User user = (User) session.getAttribute("userSession");
			log.debug("user info : " + user.getAccountName());
		} catch (Exception e) {
			log.error(e);
		}
		mv = new ModelAndView("/view/edit/changeUserInfoForm");
		return mv;
	}

	// 주요 정보만 넘어옴 , 나중에 customer, seller 등 고유 정보 바꿀수 있도록 업데이트 해야됨
	@RequestMapping(value = "submitChangeUserInfo.do")
	public ModelAndView submitUserInfo(User user, HttpSession session) {
		ModelAndView mv;
		try {
			User newUser = (User) session.getAttribute("userSession");
			user.setEmail(newUser.getEmail());
			userService.updateUserInfo(user);
		} catch (Exception e) {
			log.error(e);
		}
		mv = new ModelAndView("/view/index");
		return mv;
	}
}
