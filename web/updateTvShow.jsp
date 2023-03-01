<%-- 
    Document   : updateTvShow
    Created on : 28 feb. 2023, 18:32:12
    Author     : Samuel
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    int id = Integer.parseInt(request.getParameter("txtId"));
    String name = request.getParameter("txtName");
    int episodes = Integer.parseInt(request.getParameter("txtEpisodes"));
    String date = request.getParameter("dateRelease");
    String genre = request.getParameter("ddGenre");
    String country = request.getParameter("ddCountry");

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/MultiMedia", "root", "Admin$1234");
    Statement statement = connection.createStatement();

    String sql = "UPDATE Shows SET name='" + name + 
                         "', episodes=" + episodes + 
                         ", date='" + date + 
                         "', genre='" + genre + 
                         "', country='" + country + "' ";
            sql += "WHERE id = " + id;

    int rowsAffected = statement.executeUpdate(sql);

    if (rowsAffected == 1) {
        RequestDispatcher rd = request.getRequestDispatcher("tvshows.jsp");
        rd.forward(request, response);
    } else {
        out.println("<h1 style='color:red'>Unhandled error saving the TV Show</h1>");
        RequestDispatcher rd = request.getRequestDispatcher("tvshows.jsp");
        rd.include(request, response);
    }
%>
