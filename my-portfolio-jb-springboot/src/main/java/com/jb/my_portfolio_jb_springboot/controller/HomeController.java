package com.jb.my_portfolio_jb_springboot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//@RestController
public class HomeController 
{
		@RequestMapping("home")
		public String home() 
		{

			return "home";
		}
}
