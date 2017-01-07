package com.ai.takeaway.model;

public class Dish {

	private int dish_id;
	private String dish_name;
	private float dish_cost;
	private String dish_paid;
	private float dish_paid_money;
	private int dish_user_id;
	private int dish_order_id;

	public Dish(){
		
	}
	
	public Dish(int dish_id, String dish_name, float dish_cost, String dish_paid, float dish_paid_money,
			int dish_user_id, int dish_order_id) {
		this.dish_id = dish_id;
		this.dish_name = dish_name;
		this.dish_cost = dish_cost;
		this.dish_paid = dish_paid;
		this.dish_paid_money = dish_paid_money;
		this.dish_user_id = dish_user_id;
		this.dish_order_id = dish_order_id;
	}

	public int getDish_id() {
		return dish_id;
	}

	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public float getDish_cost() {
		return dish_cost;
	}

	public void setDish_cost(float dish_cost) {
		this.dish_cost = dish_cost;
	}

	public String getDish_paid() {
		return dish_paid;
	}

	public void setDish_paid(String dish_paid) {
		this.dish_paid = dish_paid;
	}

	public float getDish_paid_money() {
		return dish_paid_money;
	}

	public void setDish_paid_money(float dish_paid_money) {
		this.dish_paid_money = dish_paid_money;
	}

	public int getDish_user_id() {
		return dish_user_id;
	}

	public void setDish_user_id(int dish_user_id) {
		this.dish_user_id = dish_user_id;
	}

	public int getDish_order_id() {
		return dish_order_id;
	}

	public void setDish_order_id(int dish_order_id) {
		this.dish_order_id = dish_order_id;
	}

}
