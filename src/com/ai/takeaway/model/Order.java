package com.ai.takeaway.model;

import java.sql.Date;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Order {
	private int order_id;
	private int order_res_id;
	private float order_fullcost;
	private int order_user_id;

	public Order() {
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getOrder_res_id() {
		return order_res_id;
	}

	public void setOrder_res_id(int order_res_id) {
		this.order_res_id = order_res_id;
	}

	public float getOrder_fullcost() {
		return order_fullcost;
	}

	public void setOrder_fullcost(float order_fullcost) {
		this.order_fullcost = order_fullcost;
	}

	public int getOrder_user_id() {
		return order_user_id;
	}

	public void setOrder_user_id(int order_user_id) {
		this.order_user_id = order_user_id;
	}

}
