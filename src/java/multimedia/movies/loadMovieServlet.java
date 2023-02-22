/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package multimedia.movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel
 */
public class loadMovieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/MultiMedia", "root", "Admin$1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Movies WHERE id = " + id);
            resultSet.next();

            StringBuilder html = new StringBuilder();
            html.append("<html>")
                    .append("    <head>")
                    .append("        <title>TODO supply a title</title>")
                    .append("        <meta charset=\"UTF-8\">")
                    .append("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">")
                    .append("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">")
                    .append("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\" crossorigin=\"anonymous\"></script>")
                    .append("        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\" integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\" crossorigin=\"anonymous\"></script>")
                    .append("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js\" integrity=\"sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD\" crossorigin=\"anonymous\"></script>")
                    .append("    </head>")
                    .append("    <body>")
                    .append("        <nav class=\"navbar navbar-expand-md navbar-dark bg-primary\">")
                    .append("            <div class=\"container-fluid\">")
                    .append("                <a class=\"navbar-brand\" href=\"#\">Multimedia</a>")
                    .append("                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">")
                    .append("                    <span class=\"navbar-toggler-icon\"></span>")
                    .append("                </button>")
                    .append("                <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">")
                    .append("                    <div class=\"navbar-nav\">")
                    .append("                        <a class=\"nav-link active\" aria-current=\"page\" href=\"index.html\">Home</a>")
                    .append("                        <a class=\"nav-link\" href=\"getMoviesServlet\">Movies</a>                        ")
                    .append("                        <a class=\"nav-link\" href=\"tvshows.jsp\">TV Shows</a>")
                    .append("                        <a class=\"nav-link\" href=\"\">Songs</a>")
                    .append("                    </div>")
                    .append("                </div>")
                    .append("            </div>")
                    .append("        </nav> ")
                    .append("        <div class=\"container\">")
                    .append("            <div class=\"card\" style=\"width: 40rem;margin-top: 50px\">")
                    .append("                <div class=\"card-body\">")
                    .append("                    <form method=\"POST\" action=\"updateMovieServlet\">")
                    .append("                        <div class=\"form-floating mb-3\">")
                    .append("                                <input name=\"txtId\" value='" + resultSet.getInt("id") + "' type=\"number\" class=\"form-control\" placeholder=\"0\" readonly>")
                    .append("                            <label>Id</label>")
                    .append("                        </div>")
                    .append("                        <div class=\"form-floating mb-3\">")
                    .append("                                <input name=\"txtName\" value='" + resultSet.getString("name") + "' type=\"text\" class=\"form-control\" placeholder=\"0\">")
                    .append("                            <label>Name</label>")
                    .append("                        </div>")
                    .append("                        <div class=\"form-floating mb-3\">")
                    .append("                                <input name=\"txtDirector\" value='" + resultSet.getString("director") + "' type=\"text\" class=\"form-control\" placeholder=\"0\">")
                    .append("                            <label>Director</label>")
                    .append("                        </div>")
                    .append("                        <div class=\"form-floating mb-3\">")
                    .append("                                <input name=\"dateRelease\" type=\"date\" class=\"form-control\" value='" + resultSet.getString("date") + "' value=\"2023-01-01\" min=\"1965-01-01\" max=\"2024-01-01\">")
                    .append("                            <label>Date Release</label>")
                    .append("                        </div>")
                    .append("                        <div class=\"form-floating mb-3\">")
                    .append("                            <div class=\"row\">                    ")
                    .append("                                <div class=\"col-6\">")
                    .append("                                    <select class=\"form-select\" name=\"ddGenre\">")
                    .append("                                        <option value=\"Drama\" selected>Drama</option>")
                    .append("                                        <option value=\"Thriller\">Thriller</option>")
                    .append("                                        <option value=\"Terror\">Terror</option>")
                    .append("                                        <option value=\"Comedy\">Comedy</option>")
                    .append("                                    </select>")
                    .append("                                </div>")
                    .append("                                <div class=\"col-6\">")
                    .append("                                    <select class=\"form-select\" name=\"ddCountry\">")
                    .append("                                        <option value=\"USA\" selected>USA</option>")
                    .append("                                        <option value=\"Canada\">Canada</option>")
                    .append("                                        <option value=\"Mexico\">Mexico</option>")
                    .append("                                        <option value=\"Spain\">Spain</option>")
                    .append("                                    </select>")
                    .append("                                </div>")
                    .append("                            </div>")
                    .append("                        </div>")
                    .append("                        <div style=\"float:right\">")
                    .append("                            <button type=\"button\" class=\"btn btn-success\" data-bs-toggle=\"modal\" data-bs-target=\"#confirmUpdateModal\">Update movie</button>")
                    .append("                            <button type=\"button\" class=\"btn btn-danger\" data-bs-toggle=\"modal\" data-bs-target=\"#confirmDeleteModal\">Delete movie</button>")
                    .append("                        </div>")
                    .append("                        <!-- Modal Update -->")
                    .append("                       <div class=\"modal fade\" id=\"confirmUpdateModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">")
                    .append("                           <div class=\"modal-dialog modal-dialog-centered\">")
                    .append("                               <div class=\"modal-content\">")
                    .append("                                   <div class=\"modal-header\">")
                    .append("                                       <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Confirmation</h1>")
                    .append("                                       <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>")
                    .append("                                   </div>")
                    .append("                                   <div class=\"modal-body\">")
                    .append("                                       Do you really want to update this movie?")
                    .append("                                   </div>")
                    .append("                                   <div class=\"modal-footer\">")
                    .append("                                       <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>")
                    .append("                                       <button type=\"submit\" class=\"btn btn-success\">Update movie</button>")
                    .append("                                   </div>")
                    .append("                               </div>")
                    .append("                           </div>")
                    .append("                       </div>")
                    .append("                       <!-- Modal Delete -->")
                    .append("                       <div class=\"modal fade\" id=\"confirmDeleteModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">")
                    .append("                           <div class=\"modal-dialog modal-dialog-centered\">")
                    .append("                               <div class=\"modal-content\">")
                    .append("                                   <div class=\"modal-header\">")
                    .append("                                       <h1 class=\"modal-title fs-5\" id=\"exampleModalLabel\">Confirmation</h1>")
                    .append("                                       <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>")
                    .append("                                   </div>")
                    .append("                                   <div class=\"modal-body\">")
                    .append("                                       Do you really want to delete this movie?")
                    .append("                                   </div>")
                    .append("                                   <div class=\"modal-footer\">")
                    .append("                                       <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Close</button>")
                    .append("                                           <a href='deleteMovieServlet?id=" + resultSet.getString("id") + "' class=\"btn btn-danger\" type=\"submit\">Delete movie</a>")
                    .append("                                   </div>")
                    .append("                               </div>")
                    .append("                           </div>")
                    .append("                       </div>")
                    .append("                    </form> ")
                    .append("                </div>")
                    .append("            </div>")
                    .append("        </div>")
                    .append("    </body>")
                    .append("</html>");

            out.println(html);
        } catch (Exception e) {
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
