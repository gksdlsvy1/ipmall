package kr.co.ipmall.model.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		System.out.println("preHandle");
		if(session !=null) {
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo != null){
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/login/loginForm");
		return false;
	}

}
