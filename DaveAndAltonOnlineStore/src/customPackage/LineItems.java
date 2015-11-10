package customPackage;

import java.io.Serializable;

public class LineItems implements Serializable{
	private int line_itme_id;
	private int quantity;
	private double price;
	private double total_price;
	private Products product;
	private int buyer_id;
	
	public LineItems(){
		
	}

	public int getLine_itme_id() {
		return line_itme_id;
	}

	public void setLine_itme_id(int line_itme_id) {
		this.line_itme_id = line_itme_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

}
