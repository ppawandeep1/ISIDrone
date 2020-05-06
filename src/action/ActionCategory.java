package action;

import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Category;
import manager.MCategory;

public class ActionCategory {

public static boolean my_category(HttpServletRequest request, HttpServletResponse response) throws SQLException{

String[] s_formParams = {"name", "description","order"};

String[] s_formValuesNeeded = {
request.getParameter(s_formParams[0]),
request.getParameter(s_formParams[1]),
request.getParameter(s_formParams[2])} ;

boolean isCompleted = true;

HashMap<String, String> hm_formParamValue = new HashMap<String, String>();
for(int i=0; i< s_formValuesNeeded.length; i++) {
hm_formParamValue.put(s_formParams[i], s_formValuesNeeded[i]);
}
// Create the product first
Category category = new Category();
category.setName(String.valueOf(hm_formParamValue.get( "name")));
category.setDescription(String.valueOf(hm_formParamValue.get( "description")));
category.setOrder(0);

int rep = MCategory.add(category);
//Si une erreur est arrivé
System.out.println("repid"+rep);
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


public static boolean update_category(int pid, HttpServletRequest request, HttpServletResponse response) throws SQLException{
System.out.println("update category function");
String[] s_formParams = {"name", "description","order"};

String[] s_formValuesNeeded = {
request.getParameter(s_formParams[0]),
request.getParameter(s_formParams[1]),
request.getParameter(s_formParams[2])} ;

boolean isCompleted = true;

HashMap<String, String> hm_formParamValue = new HashMap<String, String>();
for(int i=0; i< s_formValuesNeeded.length; i++) {
hm_formParamValue.put(s_formParams[i], s_formValuesNeeded[i]);
}
// Create the product first
Category category = new Category();
category.setName(String.valueOf(hm_formParamValue.get( "name")));
category.setDescription(String.valueOf(hm_formParamValue.get( "description")));
category.setOrder(0);

int rep = MCategory.edit_category(pid,category);
System.out.println("repid"+rep);
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

public static void getCategories(HttpServletRequest request, HttpServletResponse response) {
request.setAttribute("categories", MCategory.getCategories());
}

public static int getSelectedCategory(HttpServletRequest request, HttpServletResponse response) {
//Permet de recevoir la catégorie sélectionné par l'utilisateur
String paramCategory = request.getParameter("category");
Integer categorySelected;

if(paramCategory != null) {
try {
//Si l'utilisateur entre lui même une valeur pour le paramêtre category dans la barre d'adresse
// alors s'il la catégorie est invalide, alors la catégorie sélectionné deviendra 1 (qui représente toutes les catégories)
categorySelected = Integer.valueOf(paramCategory);
if(MCategory.isExist(categorySelected) != 0)
categorySelected = 1;
}
catch(NumberFormatException e) {
categorySelected = 1;
}
}
else
categorySelected = 0;

return categorySelected;

}
}