package com.springboot.rest.restdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{

	Logger log =org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
	//	log.info(" AuthenticationInterceptor Request is complete");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
		//log.info(" AuthenticationInterceptor Handler execution is complete");
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		//System.out.println(request.getRequestURI());
		String[] uri=request.getRequestURI().split("/");
		if(!uri[2].equalsIgnoreCase("showlogin")) {
			HttpSession session=request.getSession();
			String userName=(String)session.getAttribute("userName");
			//System.out.println("Name :"+userName); 
			if(userName==null) {
				response.sendRedirect("/restdemo/showlogin");
			}
		}
		//System.out.println(request.getRequestURL());
		//log.info(" AuthenticationInterceptor Before Handler execution");
		return true;
	}

}
