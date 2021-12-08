package com.rms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.rms.model.OrdersTable;
import com.rms.repository.OrdersTableRepository;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@Service
public class OrdersTableService {
	
	@Autowired
	private OrdersTableRepository ordersTableRepository;
	
	public OrdersTable createOrders(OrdersTable ordersTable) {
		return ordersTableRepository.save(ordersTable);
	}
	
	public List<OrdersTable> getAllOrders(){
		return ordersTableRepository.findAll();
	}
	
	public Optional<OrdersTable> getOrdersById(int orderId){
		return ordersTableRepository.findById( orderId);
	}
	
	public void deleteOrdersById(int orderId) {
    ordersTableRepository.deleteById(orderId);
    }
	
	public OrdersTable updateOrder(OrdersTable ordersTable) {
		return ordersTableRepository.save(ordersTable);
	}
}
