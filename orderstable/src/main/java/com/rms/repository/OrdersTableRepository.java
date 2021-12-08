package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rms.model.OrdersTable;

@Repository
public interface OrdersTableRepository extends JpaRepository<OrdersTable, Integer>{

}