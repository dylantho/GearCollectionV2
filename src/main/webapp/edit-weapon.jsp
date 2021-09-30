<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gear Collection - Edit</title>
</head>
<body>

<form action = "EditWeaponServlet" method="post">
Name: <input type ="text" name = "name" value="${weaponToEdit.name}">
Weapon Type: <input type = "text" name = "weaponType" value= "${weaponToEdit.weaponType}">
<input type = "hidden" name = "id" value="${weaponToEdit.id}">
<input type = "submit" value="Save Edited Weapon">
</form>

</body>
</html>