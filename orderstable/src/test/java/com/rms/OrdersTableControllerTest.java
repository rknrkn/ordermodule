package com.rms;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rms.controller.OrdersTableController;
import com.rms.model.OrdersTable;
import com.rms.repository.OrdersTableRepository;
import com.rms.service.OrdersTableService;


@WebMvcTest(OrdersTableController.class)
@ActiveProfiles("Test")
public class OrdersTableControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	OrdersTableService ordersTableService;

	OrdersTable Order1 = new OrdersTable(1,3,4);
	OrdersTable Order2 = new OrdersTable(20,11,9);
	OrdersTable Order3 = new OrdersTable(9,5,2);

	@Test
	public void getAllOrdersTest() throws Exception {
		List<OrdersTable> orders = new ArrayList<OrdersTable>();
		orders.add(Order1);
		orders.add(Order2);
		orders.add(Order3);
		Mockito.when(ordersTableService.getAllOrders()).thenReturn(orders);

		mockMvc.perform(MockMvcRequestBuilders.get("/rms/order").contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$[0].customerId", is(3))).andExpect(jsonPath("$[1].menuId", is(9)))
		.andExpect(jsonPath("$[2].customerId", is(5)));

}

}