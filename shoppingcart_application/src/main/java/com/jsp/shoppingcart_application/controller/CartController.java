package com.jsp.shoppingcart_application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_application.dao.CartDao;
import com.jsp.shoppingcart_application.dao.CustomerDao;
import com.jsp.shoppingcart_application.dto.Cart;
import com.jsp.shoppingcart_application.dto.Customer;
import com.jsp.shoppingcart_application.dto.Items;

@Controller
public class CartController {
	
	@Autowired
	CartDao dao;

	@Autowired
	CustomerDao custdao;

	@RequestMapping("/fetchitemsfromcart")
	public ModelAndView fetchItemsFromCart(HttpSession session) {
		Customer c = (Customer) session.getAttribute("customerinfo");

		Customer customer = custdao.findCustomerById(c.getId());
		Cart cart = customer.getCart();
		List<Items> items = cart.getItems();

		ModelAndView mav = new ModelAndView();
		mav.addObject("itemslist", items);
		mav.addObject("totalprice", cart.getTotalprice());
		mav.setViewName("displaycartitemstocustomer");

		return mav;

	}

}
