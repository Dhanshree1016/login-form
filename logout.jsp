<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>

<body>
<%
        // Retrieve the session object
        HttpSession currentSession = request.getSession(false);

         if (currentSession !=null){
        	 currentSession.invalidate();
         }

           //Redirect to the login page
            response.sendRedirect("index.html");
        
%>
   
</body>
</html>