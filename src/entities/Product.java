package entities;

public class Product {
	private String name;
	private Double price;
	private Integer quantity;
	
	public Product(String name, Double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public Double getPrize() {
		return price;
	}
	
	public Integer quantity() {
		return quantity;
	}
	
	public Double getTotalPrice() {
		return price * quantity;
	}
	
	public String outputString() {
		return name + ", " + String.format("%.2f", getTotalPrice());
	}
	
	@Override
	public String toString() {
		return name + ", " + String.format("%.2f", price) + ", " + quantity;
	}
}
