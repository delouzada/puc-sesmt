<%@page import="javax.faces.context.FacesContext"%>
2<%-- 
    Document   : newjsp
    Created on : 28/05/2012, 17:51:56
    Author     : Louzada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    </body>

<%

    session.invalidate();
    
            
    response.sendRedirect("lista-funcionario.jsf");


%>

</body>