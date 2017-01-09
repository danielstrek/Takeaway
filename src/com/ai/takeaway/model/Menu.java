package com.ai.takeaway.model;

public class Menu {
	private int menu_id;
	private String menu_value;
	private float cost;
	
	public Menu(){
		
	}
	
	public Menu(String menu_value, float cost){
		this.menu_value = menu_value;
		this.cost = cost;
	}
	
	public Menu(String menu_value, int menu_id){
		this.menu_value = menu_value;
		this.menu_id = menu_id;
		this.cost = cost;

	}

	
	
	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_value() {
		return menu_value;
	}
	public void setMenu_value(String menu_value) {
		this.menu_value = menu_value;
	}

	
}
