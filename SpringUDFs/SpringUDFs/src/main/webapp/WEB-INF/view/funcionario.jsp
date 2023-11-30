<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funcionario</title>
</head>
<body>
      <div>
          <jsp:include page="menu.jsp"/>
      </div>
       <div align="center">
          <form action="funcionario" method="post">
               <table>
                 <tr>
                 
                 <td><input type="number" id="codigo" name="codigo"><td>
                 <td><input type="submit" id="botao" name="botao" value="Buscar"><td>
                 <td><input type="submit" id="botao" name="botao" value="Listar"><td>
                 
                 </tr>
               </table>
          </form>
     </div>

</body>
</html>