<%-- 
    Document   : deleteTvShow
    Created on : 28 feb. 2023, 18:42:31
    Author     : Samuel
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    int id = Integer.parseInt(request.getParameter("id"));

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/MultiMedia", "root", "Admin$1234");
    Statement statement = connection.createStatement();

    String sql = "DELETE FROM Shows WHERE id = " + id;

    int rowsAffected = statement.executeUpdate(sql);

    if (rowsAffected == 1) {
        RequestDispatcher rd = request.getRequestDispatcher("tvshows.jsp");
        rd.forward(request, response);
    } else {
        out.println("<h1 style='color:red'>Unhandled error deleting the movie</h1>");
        RequestDispatcher rd = request.getRequestDispatcher("tvshows.jsp");
        rd.include(request, response);
    }
%>
