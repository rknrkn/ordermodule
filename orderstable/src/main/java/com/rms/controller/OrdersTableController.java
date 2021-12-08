package com.rms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rms.exception.ResourceNotFoundException;

import com.rms.model.OrdersTable;
import com.rms.service.OrdersTableService;

@RestController
public class OrdersTableController {
	
	@Autowired
	private OrdersTableService  ordersTableService;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String welcome() {
		return "Please Place Your Order";
	}
	
	//place orders
	@RequestMapping(value="/order", method= RequestMethod.POST)
	public OrdersTable createOrdersTable(@Valid@RequestBody OrdersTable ordersTable) {
	return ordersTableService.createOrders(ordersTable);
	}
	
	//get orders
	@RequestMapping(value="/order", method= RequestMethod.GET)
	public List<OrdersTable> getAllOrders(){
		return ordersTableService.getAllOrders();
	}
	
	//get orders by id
	@RequestMapping(value="/order/{orderId}", method= RequestMethod.GET )
		public OrdersTable getUserDetailsById(@PathVariable("orderId") int oId) throws ResourceNotFoundException {
		Optional<OrdersTable> order = ordersTableService.getOrdersById(oId);
		if(order.isEmpty()) {
		throw new ResourceNotFoundException("Order not found with orderid: "+oId);
		}
		return order.get();
	}
	
	//update orders
	@RequestMapping(value="/order", method=RequestMethod.PUT)
	public OrdersTable OrdersTable (@Valid@RequestBody OrdersTable ordersTable) {
		return ordersTableService.updateOrder(ordersTable);
	}
	
	//delete orders by Id
	@RequestMapping(value="/order/{orderId}", method= RequestMethod.DELETE )
	public String deleteOrderDetails(@PathVariable("orderId") int oId) {
		Optional<OrdersTable> o = ordersTableService.getOrdersById(oId);
		if(o.isPresent()) {
		    ordersTableService.deleteOrdersById(oId);
			return "The Order Details deleted with the order Id: "+oId;
		}
		
		return "The Order Details Not deleted with the order Id: "+oId;
		
	}

}
