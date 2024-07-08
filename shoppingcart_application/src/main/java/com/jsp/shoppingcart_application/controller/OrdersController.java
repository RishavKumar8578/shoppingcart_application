
package com.jsp.shoppingcart_application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_application.dao.CartDao;
import com.jsp.shoppingcart_application.dao.CustomerDao;
import com.jsp.shoppingcart_application.dao.OrdersDao;
import com.jsp.shoppingcart_application.dao.ProductDao;
import com.jsp.shoppingcart_application.dto.Cart;
import com.jsp.shoppingcart_application.dto.Customer;
import com.jsp.shoppingcart_application.dto.Items;
import com.jsp.shoppingcart_application.dto.Orders;
import com.jsp.shoppingcart_application.dto.Product;


@Controller
public class OrdersController {
	
	@Autowired
	OrdersDao dao;
	
	@Autowired
	CustomerDao cdao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao cartdao;
	
	@RequestMapping("/addorder")
	public ModelAndView addOrder() {
		Orders order = new Orders();
		ModelAndView mav = new ModelAndView();
		mav.addObject("ordersobj", order);
		mav.setViewName("ordersform");
		return mav;
	}
	
	@RequestMapping("/paymentmode")
	public ModelAndView paymentMode(@ModelAttribute("ordersobj") Orders o, HttpSession session) {
		Customer c = (Customer) session.getAttribute("customerinfo");
		System.out.println("value of O=  "  +o.getAddresss()+ " "+ o.getMobilenumber() + " " + o.getName());
		Customer customer = cdao.findCustomerById(c.getId());
		Cart cart = customer.getCart();
		ModelAndView mav = new ModelAndView();
		mav.addObject("totalprice", cart.getTotalprice());
		mav.addObject("ordersobj" , o);
		mav.setViewName("payment");
		
		return mav;
	}
		
	
	
	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(@ModelAttribute("ordersobj") Orders o, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerinfo");
		
		Customer c = cdao.findCustomerById(customer.getId());
		
		Cart cart = c.getCart();
		
		List<Items> items = cart.getItems();
		
		List<Items> cartitems = new ArrayList<Items>();
		
		List<Items> orderitems = new ArrayList<Items>();
		
		for(Items i :items) {
			Product p = pdao.findProductById(i.getPid());
			System.out.println("value of p is coming = "+ p);
			if(i.getQuantity() < p.getStock()) {
				orderitems.add(i);
				p.setStock(p.getStock() - i.getQuantity());
				pdao.updateProduct(p);
			}
			else {
				cartitems.add(i);
			}
		}
		double  cartTotalPrice = 0;
		double orderTotalPrice = 0;
		
		for(Items i : cartitems) {
			cartTotalPrice+= i.getPrice();
		}
		
		for(Items i : orderitems) {
			orderTotalPrice+= i.getPrice();
		}
		
		cart.setItems(cartitems);
		cart.setTotalprice(orderTotalPrice);
		
		o.setItems(orderitems);
		o.setTotalprice(orderTotalPrice);
		
		List<Orders> orders = c.getOrders();
		
		if(orders.size()>0) {
			orders.add(o);
			c.setOrders(orders);
		}
		else {
			List<Orders> orders1 = new ArrayList<Orders>();
			orders1.add(o);
			c.setOrders(orders1);
		}
		c.setCart(cart);
		cartdao.updateCart(cart);
		dao.saveOrder(o);
		cdao.updateCustomer(c);
		System.out.println("value of O=  "  +o.getAddresss()+ " "+ o.getMobilenumber() + " " + o.getName());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "order placed successfully");
		mav.addObject("orderdetails", o);
		mav.addObject("itemslist", items);
		mav.setViewName("customerbill");

		return mav;
		
	}

}
