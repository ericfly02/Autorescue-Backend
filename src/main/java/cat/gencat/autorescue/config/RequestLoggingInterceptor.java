/**

Project: AUTORESCUE
Copyright (c) nttdata 2024 

*/
package cat.gencat.autorescue.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestLoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String method = request.getMethod();
		String requestUrl = request.getRequestURI();
		log.info("start {} {}", method, requestUrl);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String method = request.getMethod();
		String requestUrl = request.getRequestURI();
		log.info("end {} {}", method, requestUrl);
	}
}
