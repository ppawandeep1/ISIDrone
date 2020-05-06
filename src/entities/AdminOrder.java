package entities;

public class AdminOrder {
	
	// Attribute
	private int id, 
			category,
			qty;
	
	private String name,
			date,
			description,
			imgName;
	
	private double price, total_price;
	
	private boolean isShipped;

	// Constructor
	
	

	public AdminOrder() {
	}
	
	public AdminOrder(int id, String date, int qty, String name, int category, String description, String imgName,
			double price, double total_price, boolean isShipped) {
		super();
		this.id = id;
		this.date = date;
		this.qty = qty;
		this.name = name;
		this.category = category;
		this.description = description;
		this.imgName = imgName;
		this.price = price;
		this.total_price = total_price;
		this.isShipped = isShipped;
	}
	
	
	//Getters and setters
	
	public double getTotal_price() {
		return total_price;
	}

	public boolean isShipped() {
		return isShipped;
	}

	public void setShipped(boolean isShipped) {
		this.isShipped = isShipped;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setQty(int qty) {
		this.qty = qty;
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

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
