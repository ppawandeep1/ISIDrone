package entities;

public class Category {
private int order ,id;
private String name,description;

public Category() {}

public Category(int id, String name, String description) {
this.id = id;
this.order=order;
this.name = name;
this.description = description;
}

public String getName() {
return name;
}

public String getDescription() {
return description;
}

public void setName(String name) {
this.name = name;
}

public void setDescription(String description) {
this.description = description;
}

public int getOrder() {
return order;
}

public void setOrder(int order) {
this.order = order;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

}