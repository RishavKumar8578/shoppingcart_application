package com.jsp.shoppingcart_application.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_application.dao.CartDao;
import com.jsp.shoppingcart_application.dao.CustomerDao;
import com.jsp.shoppingcart_application.dto.Cart;
import com.jsp.shoppingcart_application.dto.Customer;


@Controller
public class CustomerController {
	
	@Autowired
	CustomerDao dao;
	
	@Autowired
	CartDao cdao;
	
	@RequestMapping("/addcustomer")
	public ModelAndView addMerchant() {
		Customer c = new Customer();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerobj", c);
		mav.setViewName("customerform");
		return mav;
		
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj") Customer c) {
		Cart cart = new Cart();
		c.setCart(cart);
		cdao.saveCart(cart);
		
		dao.saveCustomer(c);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Registered Successfully");
		mav.setViewName("customerloginform");
		
		return mav;
	}
	
	@RequestMapping("/validatecustomer")
	public ModelAndView customerLoginVallidation(ServletRequest req, HttpSession session) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Customer c = dao.findCustomerByEmailAndPassword(email, password);
		if(c!=null) {
			ModelAndView mav = new ModelAndView();
			session.setAttribute("customerinfo", c);
			mav.setViewName("customeroptions");
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg", "invalid credential");
			mav.setViewName("customerloginform");
			return mav;
		}
		
		
	}

	

}
