package com.example;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations = {"/test-application-context.xml" })
public class OrderDaoImplTest {
	@Autowired
	OrderDao orderDao;
	@Test
	public void testCreateOrder() {
		orderDao.deleteAll();
		Order oder = new Order();
		oder.setOrderDetailId(1);
		oder.setOrderId(14);
		assertTrue(orderDao.createOrder(oder)==1);
	}

}
