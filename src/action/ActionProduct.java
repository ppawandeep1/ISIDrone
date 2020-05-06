package action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Category;
import entities.Order;
import entities.Product;
import manager.MCategory;
import manager.MOrder;
import manager.MProduct;


public class ActionProduct {

/*public static void getCategories(HttpServletRequest request, HttpServletResponse response) {
request.setAttribute("categories", MCategory.getCategories());
}*/


public static List<Category> getCategories(){
List<Category> categoryList = MCategory.getCategories();
return categoryList;
}

public static boolean product(HttpServletRequest request, HttpServletResponse response) throws SQLException {
System.out.println("POST DATA step 4");

String[] s_formParams = {"category","name", "description", "price", "serialNumber",
"imgName", "stockQty"};

String[] s_formValuesNeeded = {
request.getParameter(s_formParams[0]),
request.getParameter(s_formParams[1]),
request.getParameter(s_formParams[2]),
request.getParameter(s_formParams[3]),
request.getParameter(s_formParams[4]),
request.getParameter(s_formParams[5]),
request.getParameter(s_formParams[6]),};

boolean isCompleted = true;

HashMap<String, String> hm_formParamValue = new HashMap<String, String>();
for(int i=0; i< s_formValuesNeeded.length; i++) {
hm_formParamValue.put(s_formParams[i], s_formValuesNeeded[i]);
}





// Create the product first
Product product = new Product();

product.setCategory(Integer.valueOf(hm_formParamValue.get("category")));
product.setName(String.valueOf(hm_formParamValue.get( "name")));
product.setDescription(String.valueOf(hm_formParamValue.get( "description")));
product.setPrice(Float.valueOf(hm_formParamValue.get( "price")));
product.setSerialNumber(String.valueOf(hm_formParamValue.get("serialNumber")));
product.setImgName(String.valueOf(hm_formParamValue.get("imgName")));
product.setStockQty(Integer.valueOf(hm_formParamValue.get("stockQty")));

int rep = MProduct.add(product);

//Si une erreur est arrivé
if(rep < 1) {
isCompleted = false;
if(rep == 0)
request.setAttribute("error", "accountExisting");
else if(rep == -1)
request.setAttribute("error", "DBProblem");
}




if(!isCompleted)
request.setAttribute("hm_formParamValue", hm_formParamValue);
return isCompleted;
}

public static boolean update2(int pid, HttpServletRequest request, HttpServletResponse response) throws SQLException {
System.out.println("Actionproduct update2 function");

String[] s_formParams = {"category","name", "description", "price", "serialNumber",
"imgName", "stockQty"};

String[] s_formValuesNeeded = {
request.getParameter(s_formParams[0]),
request.getParameter(s_formParams[1]),
request.getParameter(s_formParams[2]),
request.getParameter(s_formParams[3]),
request.getParameter(s_formParams[4]),
request.getParameter(s_formParams[5]),
request.getParameter(s_formParams[6]),};

boolean isCompleted = true;

HashMap<String, String> hm_formParamValue = new HashMap<String, String>();
for(int i=0; i< s_formValuesNeeded.length; i++) {
hm_formParamValue.put(s_formParams[i], s_formValuesNeeded[i]);
}





// Create the product first
Product product = new Product();

product.setCategory(Integer.valueOf(hm_formParamValue.get("category")));
product.setName(String.valueOf(hm_formParamValue.get( "name")));
product.setDescription(String.valueOf(hm_formParamValue.get( "description")));
product.setPrice(Float.valueOf(hm_formParamValue.get( "price")));
product.setSerialNumber(String.valueOf(hm_formParamValue.get("serialNumber")));
product.setImgName(String.valueOf(hm_formParamValue.get("imgName")));
product.setStockQty(Integer.valueOf(hm_formParamValue.get("stockQty")));


int rep1 = MProduct.update(pid,product);
System.out.println(rep1);
//Si une erreur est arrivé
if(rep1 < 1) {
isCompleted = false;
if(rep1 == 0)
request.setAttribute("error", "accountExisting");
else if(rep1 == -1)
request.setAttribute("error", "DBProblem");
}




if(!isCompleted)
request.setAttribute("hm_formParamValue", hm_formParamValue);
return isCompleted;
}

}