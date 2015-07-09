package kr.co.ipmall.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.co.ipmall.dao.vo.AuthInfo;
import kr.co.ipmall.model.exception.IdPasswordNotMatchingException;
import kr.co.ipmall.service.ChangePasswordService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChangePwdController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="changePasswordService")
	private ChangePasswordService changePasswordService;
	
	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	@RequestMapping(value= "changePwdForm.do" ,method = RequestMethod.GET)
	public ModelAndView form(@ModelAttribute("command") ChangePwdCommand pwdCdm) {
		ModelAndView mv = new ModelAndView("/view/edit/changePwdForm");
		return mv;
	}
	
	@RequestMapping(value= "changePwd.do",method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("command") ChangePwdCommand pwdCmd, Errors errors, HttpSession session) {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		ModelAndView mv;
		if(errors.hasErrors()) {
			System.out.println(errors);
			mv = new ModelAndView("/view/edit/changePwdForm");
			return mv;
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		try{
			changePasswordService.changePassword(authInfo.getEmail(), pwdCmd.getCurrentPassword(), pwdCmd.getNewPassword());
			mv = new ModelAndView("/view/index");
			return mv;
		} catch(IdPasswordNotMatchingException e) {
			errors.rejectValue("currentPassword", "notMatching");
			mv = new ModelAndView("/view/edit/changePwdForm");
			return mv;
		}
	}
}
