package com.tk.rabbitmq;

import java.util.UUID;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tk.rabbitmq.common.entity.Order;
import com.tk.rabbitmq.producer.OrderSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	OrderSender orderSender;
	@Test
	public void contextLoads() {
	}

	@Test
	public void sendMsg() {
		IntStream.range(0, 21).forEach(f ->{
			Order order = new Order();
			order.setId(f);
			order.setName("测试订单"+f);
			order.setMessageId(System.currentTimeMillis()+"$"+order.getId());
			orderSender.send(order);
		});
		
	}
}
