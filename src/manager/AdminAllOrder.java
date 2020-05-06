package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.AdminOrder;

public class AdminAllOrder {
	
	public static ArrayList<AdminOrder> getOrders(){
	  
	    
		ArrayList<AdminOrder> orderlist = new ArrayList<AdminOrder>();
		try 
		{
			MDB.connect();
			String query;
			PreparedStatement ps;
			ResultSet rs;
			
			query ="SELECT o.id, o.date, o.isShipped, p.name, SUM(oi.qty) as qty, p.category,p.description, SUM(p.price) as total_price, oi.price, p.imgName FROM isidrone.order o, isidrone.product p, isidrone.order_info oi WHERE o.id = oi.order_id AND oi.product_id = p.id AND o.isActive = 1 GROUP BY o.id;";
				//query = "SELECT * FROM product";
			ps = MDB.getPS(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				orderlist.add(getOrderFromResultSet(rs));
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
	
	//view detail of particular order
	public static ArrayList<AdminOrder> getOrderById(int id){
	  
		
		ArrayList<AdminOrder> orderalllist = new ArrayList<AdminOrder>();
		try {
			MDB.connect();
			String query = "SELECT o.id, o.date, o.isShipped, p.name, oi.qty, p.category,p.description, p.price, oi.price, p.imgName FROM isidrone.order o, isidrone.product p, isidrone.order_info oi WHERE o.id = oi.order_id AND oi.product_id = p.id AND o.id = ?";
			
			PreparedStatement ps = MDB.getPS(query);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				orderalllist.add(getOrderFromResultSet(rs));
				System.out.println(rs.getBoolean("isShipped"));
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MDB.disconnect();
		}
		
		return orderalllist;
	}		  

	private static AdminOrder getOrderFromResultSet(ResultSet rs) {

		AdminOrder order = new AdminOrder();
		
		try {
			order.setId(rs.getInt("id"));
			order.setQty(rs.getInt("qty"));
			order.setCategory(rs.getInt("category"));
			order.setName(rs.getString("name"));
			order.setDescription(rs.getString("description"));
			order.setPrice(rs.getDouble("price"));
			order.setImgName(rs.getString("imgName"));
			order.setDate(rs.getString("date"));
			order.setShipped(rs.getBoolean("isShipped"));
			order.setTotal_price(rs.getDouble("total_price"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	
}
