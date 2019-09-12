package com.chenrui.restonspringwebmvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserRestController {

	@GetMapping(value="/user/{id}")
	public Person getPerson(@PathVariable String id,@RequestParam String name){
		Person p = new Person();
		p.setId("345");
		p.setName("你好");
		return p;
	}

	@GetMapping(value="/exceptionNull")
	public Person exception() {
		throw new NullPointerException("故意抛异常！");
	}

	@GetMapping(value="/notfound.html")
	public Object notfound(HttpStatus status,HttpServletRequest request,Throwable throwable) {
		Map<String,Object> errors = new HashMap<>();
		errors.put("statusCode",	request.getAttribute("javax.servlet.error.status_code"));
		errors.put("requestUri",	request.getAttribute("javax.servlet.error.request_uri"));
		return errors;
	}


}
