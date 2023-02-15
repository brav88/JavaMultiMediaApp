/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package multimedia.movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel
 */
public class saveMovieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        try {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String name = request.getParameter("txtName");
            String director = request.getParameter("txtDirector");
            String date = request.getParameter("dateRelease");
            String genre = request.getParameter("ddGenre");
            String country = request.getParameter("ddCountry");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/MultiMedia", "root", "Admin$1234");
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO Movies (id, name, director, date, genre, country) ";
            sql += "VALUES (" + id + ", '" + name + "', '" + director + "', '" + date + "', '" + genre + "', '" + country + "')";

            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected == 1) {
                RequestDispatcher rd = request.getRequestDispatcher("getMoviesServlet");
                rd.forward(request, response);
            } else {
                out.println("<h1 style='color:red'>Unhandled error saving the movie</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("getMoviesServlet");
                rd.include(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h1 style='color:red'>Unhandled error saving the movie: " + e.getMessage() + "</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("getMoviesServlet");
            rd.include(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
