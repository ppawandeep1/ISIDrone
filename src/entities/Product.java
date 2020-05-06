package entities;

public class Product{

int id;
int category;
String name, description;
float price;
String serialNumber;
String imgName;
int stockQty;


public Product() {}
public Product( int id, int category, String name, String description, float price, String serialNumber,
String imgName, int stockQty) {
super();
this.id = id;
this.category = category;
this.name = name;
this.description = description;
this.price = price;
this.serialNumber = serialNumber;
this.imgName = imgName;
this.stockQty = stockQty;
//this.isActive = isActive;



}


public int getId() {
return id;
}


public void setId(int id) {
this.id = id;
}


public int getCategory() {
return category;
}


public void setCategory(int category) {
this.category = category;
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


public float getPrice() {
return price;
}


public void setPrice(float price) {
this.price = price;
}


public String getSerialNumber() {
return serialNumber;
}


public void setSerialNumber(String serialNumber) {
this.serialNumber = serialNumber;
}


public String getImgName() {
return imgName;
}


public void setImgName(String imgName) {
this.imgName = imgName;
}


public int getStockQty() {
return stockQty;
}


public void setStockQty(int stockQty) {
this.stockQty = stockQty;
}


/* public boolean isActive() {
return isActive;
}


public void setActive(boolean isActive) {
this.isActive = isActive;
}
*/




}