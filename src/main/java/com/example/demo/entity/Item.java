package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class  Item{
	@Id
	@Column(name = "item_id")
	private int id;
	@Column(name = "item_name", nullable = false, length = 50)
	private String name;
	@Column(name = "item_category", nullable = false, length = 50)
	private String category;
	@Column(name = "item_stock", nullable = false, length = 50)
	private int stock;
	@Column(name = "item_price", nullable = false, length = 50)
	private int price;
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", category=" + category + ", stock=" + stock + ", price=" + price
				+ "]";
	}
	
}