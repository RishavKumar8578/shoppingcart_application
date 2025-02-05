package com.jsp.shoppingcart_application.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_application.dto.Orders;
import com.jsp.shoppingcart_application.dto.Product;

@Repository
public class OrdersDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public void saveOrder(Orders order) {
		EntityManager  em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(order);
		et.commit();
	}
	
	public Orders findOrderById(int id) {
		EntityManager em = emf.createEntityManager();
		Orders o = em.find(Orders.class, id);
		if (o != null)
			return o;
		else
			return null;
	}
	
	public void updateOrder(Orders o) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(o);
		et.commit();
	}
	
	public void deleteOrderById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Orders o = em.find(Orders.class, id);
		
		et.begin();
		em.remove(o);
		et.commit();
	}
	
	public List<Orders> findAllOrder(){
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select o from Orders o");
		List<Orders> orders = query.getResultList();
		return orders;
	}
	
	public List<Orders> findOrdersByBrand(String brand){
		return null;
	}

}
