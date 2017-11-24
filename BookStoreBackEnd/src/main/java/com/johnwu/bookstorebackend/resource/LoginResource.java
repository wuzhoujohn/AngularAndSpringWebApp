package com.johnwu.bookstorebackend.resource;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.johnwu.bookstorebackend.service.UserService;

@RestController
public class LoginResource {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/token")
	public Map<String, String> token(HttpSession session, HttpServletRequest request) {
		System.out.println(request.getRemoteHost());
		
		String remoteHost = request.getRemoteHost();
		int portNumber = request.getRemotePort();
		
		System.out.println(remoteHost+":"+portNumber);
		System.out.println(request.getRemoteAddr());
		
		return Collections.singletonMap("token", session.getId());
	}
	
	@RequestMapping("/checkSession")
	public ResponseEntity<Boolean> checkSession(){
		//System.out.println("we are in checkSession");
		HttpHeaders httpHeaders = new HttpHeaders();
		//System.out.println("going to return responseEntiry");
		//does not support string, dont give a string a parameter
		return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/logout", method=RequestMethod.POST)
	public ResponseEntity<Boolean> logout(){
		//System.out.println("we are in user logout");
		//String name = SecurityContextHolder.getContext().getAuthentication().getName();
		//System.out.println("name is " + name);
		SecurityContextHolder.clearContext();
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity(true, httpHeaders, HttpStatus.OK);
	}
}
