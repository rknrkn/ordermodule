package com.rms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class OrdersTable implements Serializable{
@Id
@GeneratedValue
private int orderId;

@NotNull
private long customerId;

@NotNull
private long menuId;

@Temporal(TemporalType.TIMESTAMP)
@Column(nullable=false)
private Date DateOrderPlaced;

@PrePersist
private void onCreate() {
	DateOrderPlaced=new Date();
}

public OrdersTable(int orderId, long customerId, long menuId) {
	super();
	this.orderId = orderId;
	this.customerId = customerId;
	this.menuId = menuId;
}
public OrdersTable() {
	super();
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public long getCustomerId() {
	return customerId;
}
public void setCustomerId(long customerId) {
	this.customerId = customerId;
}
public long getMenuId() {
	return menuId;
}
public void setMenuId(long menuId) {
	this.menuId = menuId;
}
@Override
public String toString() {
	return "OrdersTable [orderId=" + orderId + ", customerId=" + customerId + ", menuId=" + menuId + "]";
}



}
