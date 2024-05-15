package com.ssafy.board.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AdminPageInterceptor implements HandlerInterceptor {
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		// 세션에서 loginUser 라고 하는 사람의 정보가 admin과 동일하다면...
//		HttpSession session = request.getSession();
//		if (!"admin".equals(session.getAttribute("loginUser"))) {
//			response.sendRedirect("list");
//			return false;
//		}
//
//		return true; // 통과
//	}
	
	/**
	 * 사용자의 요청을 처리하기 전에 session에 loginUser가 있는지 판단한다.
	 * 정보가 있다면 그대로 진행하고, 정보가 없다면 index 페이지로 이동시킨다.
	 */
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		HttpSession session = request.getSession();
//		// 세션에 로그인 정보가 있다면 그대로 진행한다.
//		if(session.getAttribute("loginUser")!=null) {
//			return true;
//		}
//		// 세션 정보가 없다면 index로 redirect 시킨다.
//		else {
//			response.sendRedirect(request.getContextPath()+"/index");
//			return false;
//		}
//	}
}
