package com.chenrui.restonspringwebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * spring mvc  rest异常处理
 */
@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler({NullPointerException.class
			,IllegalAccessException.class,
			IllegalStateException.class,
	})
	public Object handle(HttpServletRequest request, HttpServletResponse response,Throwable throwable) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("msg",throwable.getMessage());
			return map;
	}
}
