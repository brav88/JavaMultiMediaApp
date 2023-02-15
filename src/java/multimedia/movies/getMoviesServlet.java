/*
   Website formatter: http://pojo.sodhanalibrary.com/string.html
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package multimedia.movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel
 */
public class getMoviesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/MultiMedia", "root", "Admin$1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Movies ORDER BY id ASC");

            StringBuilder html = new StringBuilder();
            html.append("<html>")
                    .append("    <head>")
                    .append("        <title>Multimedia</title>")
                    .append("        <meta charset=\"UTF-8\">")
                    .append("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">")
                    .append("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">")
                    .append("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\" crossorigin=\"anonymous\"></script>")
                    .append("    </head>")
                    .append("    <body>")
                    .append("       <nav class=\"navbar navbar-expand-md navbar-dark bg-primary\">")
                    .append("            <div class=\"container-fluid\">")
                    .append("                <a class=\"navbar-brand\" href=\"#\">Multimedia</a>")
                    .append("                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">")
                    .append("                    <span class=\"navbar-toggler-icon\"></span>")
                    .append("                </button>")
                    .append("                <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">")
                    .append("                    <div class=\"navbar-nav\">")
                    .append("                        <a class=\"nav-link active\" aria-current=\"page\" href=\"index.html\">Home</a>")
                    .append("                        <a class=\"nav-link\" href=\"getMoviesServlet\">Movies</a>                        ")
                    .append("                        <a class=\"nav-link\" href=\"getSeriesServlet\">Series</a>")
                    .append("                        <a class=\"nav-link\" href=\"\">Songs</a>")
                    .append("                    </div>")
                    .append("                </div>")
                    .append("            </div>")
                    .append("        </nav>")
                    .append("        <div class=\"container\" style='margin-top:100px'>")
                    .append("           <div style='float:right'>")
                    .append("               <a href='addMovie.html' class='btn btn-success'>Add movie</a>")
                    .append("           </div>")
                    .append("           <table class=\"table table-hover\">")
                    .append("               <thead>")
                    .append("                   <tr>")
                    .append("                       <th scope=\"col\">Id</th>")
                    .append("                       <th scope=\"col\">Name</th>")
                    .append("                       <th scope=\"col\">Director</th>")
                    .append("                       <th scope=\"col\">Date</th>")
                    .append("                       <th scope=\"col\">Genre</th>")
                    .append("                       <th scope=\"col\">Country</th>")
                    .append("                   </tr>")
                    .append("               </thead>")
                    .append("           <tbody>");

            while (resultSet.next()) {
                html.append("<tr onclick=\"window.location.href='loadMovieServlet?id=" + resultSet.getInt("id") + "'\">")
                        .append("<td>" + resultSet.getInt("id") + "</td>")
                        .append("<td>" + resultSet.getString("name") + "</td>")
                        .append("<td>" + resultSet.getString("director") + "</td>")
                        .append("<td>" + resultSet.getDate("date") + "</td>")
                        .append("<td>" + resultSet.getString("genre") + "</td>")
                        .append("<td>" + resultSet.getString("country") + "</td>")
                        .append("</tr>");
            }

            html.append("</tbody>")
                    .append("</table>")
                    .append("</div>")
                    .append("</body>")
                    .append("</html>");

            out.println(html);
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e.getMessage());
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
