package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Product;

public class MProduct {



private static final int ps = 0;

public static int add(Product product) throws SQLException {
System.out.println("POST DATA step 2");
int returnVal = 0;

try {
MDB.connect();

// Ajoute l'address a la BD
//MSignUp.addAddress(user.getShipAddress());

String query = "INSERT INTO isidrone.product (category,name,description,price,serialNumber,imgName, stockQty )" + " VALUES (?,?,?,?,?,?,?)";

PreparedStatement ps = MDB.getPS(query);

ps.setInt(1, product.getCategory());
ps.setString(2, product.getName());
ps.setString(3, product.getDescription());
ps.setFloat(4, product.getPrice());
ps.setString(5, product.getSerialNumber());
ps.setString(6, product.getImgName());
ps.setInt(7, product.getStockQty());

ps.executeUpdate();
 returnVal = 1;
} catch (SQLException e) {
e.printStackTrace();
 returnVal = 0;
}
finally {
MDB.disconnect();
}

//return ;
return returnVal;
}


public static int update(int pid, Product product) throws SQLException {

int returnVal = 0;

try {
MDB.connect();

// Ajoute l'address a la BD
//MSignUp.addAddress(user.getShipAddress());

String query = "UPDATE product SET category = ? , "
+ " name = ? , "
+ " description= ? ," + " price = ? ," + " serialNumber = ? ," + " imgName = ? ," + " stockQty = ?" +" where id = ?";

PreparedStatement ps = MDB.getPS(query);

ps.setInt(1, product.getCategory());
ps.setString(2, product.getName());
ps.setString(3, product.getDescription());
ps.setFloat(4, product.getPrice());
ps.setString(5, product.getSerialNumber());
ps.setString(6, product.getImgName());
ps.setInt(7, product.getStockQty());
ps.setInt(8, pid);
//System.out.println(ps.toString());
ps.executeUpdate();
returnVal = 1;
} catch (SQLException e) {
e.printStackTrace();
returnVal = 0;
}
finally {
MDB.disconnect();

}

return returnVal;

}

public static ArrayList<Product> getProductById(int id){


ArrayList<Product> productlist = new ArrayList<Product>();
try {
MDB.connect();
String query ="SELECT * FROM product WHERE id =?";
PreparedStatement ps = MDB.getPS(query);
ps.setInt(1,id);
ResultSet rs = ps.executeQuery();

while(rs.next()) {
productlist.add(getProductFromResultSet(rs));
}

} catch (SQLException e) {
e.printStackTrace();
}
finally {
MDB.disconnect();
}

return productlist;
}





public static ArrayList<Product> getProducts(){
ArrayList<Product> productlist = new ArrayList<Product>();
try
{
MDB.connect();
String query;
PreparedStatement ps;
ResultSet rs;

query ="SELECT * FROM product WHERE isActive = 1";
//query = "SELECT * FROM product";
ps = MDB.getPS(query);

rs = ps.executeQuery();

while(rs.next()){
productlist.add(getProductFromResultSet(rs));
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
return productlist;
}


private static Product getProductFromResultSet(ResultSet rs) {

Product prod = new Product();

try {

prod.setId(rs.getInt("id"));
prod.setCategory(rs.getInt("category"));
prod.setName(rs.getString("name"));
prod.setDescription(rs.getString("description"));
prod.setPrice(rs.getFloat("price"));
prod.setSerialNumber(rs.getString("serialNumber"));
prod.setImgName(rs.getString("imgName"));
prod.setStockQty(rs.getInt("stockQty"));
} catch (SQLException e) {
e.printStackTrace();
}
return prod;
}


/***********************************************************************/




}