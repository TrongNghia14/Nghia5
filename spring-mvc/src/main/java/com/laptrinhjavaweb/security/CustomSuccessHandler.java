package com.laptrinhjavaweb.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.util.SecurityUtils;


//Sau thi kiểm tra tài khoản thì đây là nơi kiểm tra quyền của tài khoản và chuyển hướng người đăng nhập tới trang tương ứng
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		//Hàm này có nhiệm vụ chuyển hướng tới url tương ứng
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}


	private String determineTargetUrl(Authentication authentication) {
		// Đây sẽ là nơi kiểm tra và trả về đường dẫn đúng với tài khoản đăng nhập vô
		//Có thể vô trang chủ hoặc trang quản trị
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if(isAdmin(roles)) {
			url = "/quan-tri/trang-chu";
		}else if (isUser(roles)) {
			url = "/trang-chu";
		}
		return url;
	}

	private boolean isAdmin(List<String> roles) {
		if(roles.contains("ADMIN"))
			return true;
		return false;
	}
	
	private boolean isUser(List<String> roles) {
		if(roles.contains("USER"))
			return true;
		return false;
	}
	
}
