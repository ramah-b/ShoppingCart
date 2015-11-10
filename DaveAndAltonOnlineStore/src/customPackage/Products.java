package customPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class Products implements Serializable{
	private int product_id;
	private String name;
	private String description;
	private double price;
	private String category;
	private int quantity;
	private ArrayList<LineItems> lineItemsList = new ArrayList<LineItems>();
	
	public Products(){
		
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<LineItems> getLineItemsList() {
		return lineItemsList;
	}

	public void setLineItemsList(ArrayList<LineItems> lineItemsList) {
		this.lineItemsList = lineItemsList;
	}

}
