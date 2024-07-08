package com.jsp.shoppingcart_application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_application.dao.CartDao;
import com.jsp.shoppingcart_application.dao.CustomerDao;
import com.jsp.shoppingcart_application.dao.ItemDao;
import com.jsp.shoppingcart_application.dao.ProductDao;
import com.jsp.shoppingcart_application.dto.Cart;
import com.jsp.shoppingcart_application.dto.Customer;
import com.jsp.shoppingcart_application.dto.Items;
import com.jsp.shoppingcart_application.dto.Merchant;
import com.jsp.shoppingcart_application.dto.Product;

@Controller
public class ItemController {
	
	@Autowired
	ItemDao dao;

	@Autowired
	ProductDao pdao;

	
	@Autowired
	CartDao cdao;

	@Autowired
	CustomerDao custdao;
	
	@RequestMapping("additem")
	public ModelAndView addItem(@RequestParam("id") int id) {
		Product p = pdao.findProductById(id);
		
		Items i = new Items();
		i.setBrand(p.getBrand());
		i.setCategory(p.getCategory());
		i.setPrice(p.getPrice());
		i.setPid(p.getId());
		
		System.out.println("inside add item = "+p.getId() +" " + p.getBrand() + " " + i.getPid());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemsobj", i);
		mav.setViewName("itemform");
		
		return mav;
		
	}
	
	@RequestMapping("/additemtocart")
	public ModelAndView addItemToCart(@ModelAttribute("itemsobj") Items i, HttpSession session) {
		System.out.println(i.getBrand()+ " " + i.getPid());
		i.setPrice(i.getQuantity()*i.getPrice());
		Customer customer = (Customer) session.getAttribute("customerinfo");
		System.out.println("Customer vlue=" +customer);
		Cart cart = customer.getCart();
		
		cart.setName(customer.getName());
		List<Items> items = cart.getItems();
		if(items.size() >0) {
			items.add(i);
			cart.setItems(items);
			
			cart.setTotalprice(cart.getTotalprice() + i.getPrice());
			
		}else {
			List<Items> items1 = new ArrayList<Items>();
			items1.add(i);
			
			cart.setTotalprice(i.getPrice());
			cart.setItems(items1);
		}
			dao.saveItem(i);
			cdao.updateCart(cart);
			
		    ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect://fetchallproducts");
			return mav;
		
		
	}
	
//	@RequestMapping("/deleteitem")
//	public ModelAndView deleteItem(@RequestParam("id") int id, HttpSession session) {
//		Cart cart = (Cart) session.getAttribute("itemsobj");
//		Items i = dao.deleteItemById(item.getId(), id);
//		dao.updateItem(i);
//		dao.deleteProductById(pid);
//		
//		session.setAttribute("merchantinfo", merchant);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect://displayallproducts");
//		return mav;
//	
//	
//	}
}


