package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Category;


public class MCategory {

private static final int ps = 0;

public static int add(Category category) throws SQLException {

try {
MDB.connect();
String query = "INSERT INTO category (`name`, `description`, `order`) VALUES (?, ?, ?)";
PreparedStatement ps = MDB.getPS(query);
ps.setString(1, category.getName());
ps.setString(2, category.getDescription());
ps.setInt(3,0);
ps.executeUpdate();
} catch (SQLException e) {
e.printStackTrace();
}
finally {
MDB.disconnect();
}
return ps;
}

public static ArrayList<Category> getCategories(){
ArrayList<Category> categories = new ArrayList<Category>();

try {
MDB.connect();
String query = "SELECT * FROM category WHERE isActive = 1";
ResultSet rs = MDB.execQuery(query);
while(rs.next()) {
categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
}

} catch (SQLException e) {
e.printStackTrace();
}
finally {
MDB.disconnect();
}

return categories;
}

public static int isExist(int category) {
int isExist = -1;
try {
MDB.connect();
String query = "SELECT 'exist' FROM category WHERE id = ?";
PreparedStatement ps = MDB.getPS(query);

ps.setInt(1, category);
ResultSet rs = ps.executeQuery();

isExist = (rs.first() ? 0 : 1);
} catch (SQLException e) {
isExist = -1;
e.printStackTrace();
}
finally {
MDB.disconnect();
}

return isExist;
}

public static int edit_category(int pid,Category category) throws SQLException
{
int returnvalue = 0;
try {
MDB.connect();

String query = "UPDATE category SET "+ "name = ?, "
+ "description= ? " +" where id = ?";

PreparedStatement ps = MDB.getPS(query);

ps.setString(1, category.getName());
ps.setString(2, category.getDescription());
ps.setInt(3, pid);

ps.executeUpdate();
returnvalue = 1;
} catch (SQLException e) {
e.printStackTrace();
returnvalue = 0;
}
finally {
MDB.disconnect();
}
return returnvalue;
}

public static ArrayList<Category> getCategorytById(int id){
ArrayList<Category> categorylist = new ArrayList<Category>();
try {
MDB.connect();
String query ="SELECT * FROM category WHERE id =?";

PreparedStatement ps = MDB.getPS(query);
ps.setInt(1,id);
ResultSet rs = ps.executeQuery();

while(rs.next()) {
categorylist.add(getOrderCategoryFromResultSet(rs));
}

} catch (SQLException e) {
e.printStackTrace();
}
finally {
MDB.disconnect();
}

return categorylist;
}

public static ArrayList<Category> getOrdersCategory(){
ArrayList<Category> orderlist = new ArrayList<Category>();
try
{
MDB.connect();
String query;
PreparedStatement ps;
ResultSet rs;

query ="SELECT * FROM category WHERE isActive = 1";

ps = MDB.getPS(query);
rs = ps.executeQuery();
while(rs.next()){
orderlist.add(getOrderCategoryFromResultSet(rs));
}
}
catch (SQLException e)
{
e.printStackTrace();
}
finally
{
MDB.disconnect();
}
return orderlist;
}

private static Category getOrderCategoryFromResultSet(ResultSet rs) {
Category order = new Category();
try {
order.setName(rs.getString("name"));
order.setDescription(rs.getString("description"));
order.setId(rs.getInt("id"));
} catch (SQLException e) {
e.printStackTrace();
}
return order;
}
}