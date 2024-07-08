package com.jsp.shoppingcart_application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.jsp.shoppingcart_application.dao.MerchantDao;
import com.jsp.shoppingcart_application.dao.ProductDao;
import com.jsp.shoppingcart_application.dto.Merchant;
import com.jsp.shoppingcart_application.dto.Product;
import com.mysql.cj.Session;

@Controller
public class ProductController {
	
	@Autowired
	ProductDao dao;
	
	@Autowired
	MerchantDao mdao;
	
	@RequestMapping("/addproduct")
	public ModelAndView addstudentMethod() {
		Product p = new Product();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", p);
		mav.setViewName("productjstlform");
		return mav;
	}
	
	@RequestMapping("/saveproduct")
	public ModelAndView saveStudentMethod(@ModelAttribute("productobj") Product product, HttpSession session) {
		Merchant m = (Merchant)session.getAttribute("merchantinfo");
		
		List<Product> products = m.getProducts();
		
		if(products.size()>0) {
			products.add(product);
			m.setProducts(products);
		}else {
			List<Product> products1 = new ArrayList<Product>();
			products1.add(product);
			
			m.setProducts(products1);
		}
		dao.saveProduct(product);
		mdao.updateMerchant(m);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "data saved successfully....");
		mav.setViewName("merchantoption");
		return mav;
	}
	
	@RequestMapping("/viewallproducts")
	public ModelAndView viewAllProducts(HttpSession session) {
		
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		Merchant merchant = mdao.findMerchantById(m.getId());
		List<Product> products = merchant.getProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist", products);
		mav.setViewName("displayallproducts");
		
		return mav;
	}
	
	@RequestMapping("deleteproducts")
	public ModelAndView deleteStudent(@RequestParam("id") int pid, HttpSession session) {
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		Merchant merchant = dao.removeProductFromMerchant(m.getId(), pid);
		mdao.updateMerchant(merchant);
		dao.deleteProductById(pid);
		
		session.setAttribute("merchantinfo", merchant);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://displayallproducts");
		return mav;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateInfo(@RequestParam("id") int id) {
		Product p = dao.findProductById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productdetails", p);
		mav.setViewName("updateproduct");
		return mav;
	}
	@RequestMapping("/updateproductinfo")
	public ModelAndView updateStudent(@ModelAttribute("productdetails") Product p) {
		dao. updateProduct(p);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://displayallproducts");
		return mav;
	}
	
	@RequestMapping("fetchallproducts")
	public ModelAndView fetchAllProducts() {
		List<Product> products = dao.findAllProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist", products);
		mav.setViewName("viewallproducts");
		
		return mav;
		
	}
	

}
