package com.jsp.shoppingcart_application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_application.dto.Customer;
import com.jsp.shoppingcart_application.dto.Items;
import com.jsp.shoppingcart_application.dto.Product;

@Repository
public class ItemDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	public void saveItem(Items item) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(item);
		et.commit();
	}
	
	public Items findItemById(int id) {
		EntityManager em = emf.createEntityManager();
		Items i = em.find(Items.class, id);
		if (i != null)
			return i;
		else
			return null;
	}
	public void updateItem(Items item) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(item);
		et.commit();
	}
	
	public void deleteItemById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Items item = em.find(Items.class, id);
		
		et.begin();
		em.remove(item);
		et.commit();
	}

}
