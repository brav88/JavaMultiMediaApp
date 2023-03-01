<%-- 
    Document   : loadTvShow
    Created on : 28 feb. 2023, 18:16:04
    Author     : Samuel
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit TV Show</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-primary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Multimedia</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" aria-current="page" href="index.html">Home</a>
                        <a class="nav-link" href="getMoviesServlet">Movies</a>                        
                        <a class="nav-link" href="tvshows.jsp">TV Show</a>
                        <a class="nav-link" href="">Songs</a>
                    </div>
                </div>
            </div>
        </nav> 
        <%
            int id = Integer.parseInt(request.getParameter("id"));

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/MultiMedia", "root", "Admin$1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Shows WHERE id = " + id);
            resultSet.next();    
        %>
        <div class="container">
            <div class="card" style="width: 40rem;margin-top: 50px">
                <div class="card-body">
                    <form method="POST" action="updateTvShow.jsp">
                        <div class="form-floating mb-3">
                            <input value=<%=resultSet.getInt("id") %> name="txtId" type="number" class="form-control" placeholder="0" readonly>
                            <label>Id</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input value='<%=resultSet.getString("name") %>' name="txtName" type="text" class="form-control" placeholder="0">
                            <label>Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input value=<%=resultSet.getString("episodes") %> name="txtEpisodes" type="text" class="form-control" placeholder="0">
                            <label>Episodes</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input value=<%=resultSet.getString("date") %> name="dateRelease" type="date" class="form-control" value="2023-01-01" min="1965-01-01" max="2024-01-01">
                            <label>Date Release</label>
                        </div>
                        <div class="form-floating mb-3">
                            <div class="row">                    
                                <div class="col-6">
                                    <select class="form-select" name="ddGenre">
                                        <option value="Drama" selected>Drama</option>
                                        <option value="Thriller">Thriller</option>
                                        <option value="Terror">Terror</option>
                                        <option value="Comedy">Comedy</option>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <select class="form-select" name="ddCountry">
                                        <option value="USA" selected>USA</option>
                                        <option value="Canada">Canada</option>
                                        <option value="Mexico">Mexico</option>
                                        <option value="Spain">Spain</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div style="float:right">
                            <button class="btn btn-success" type="submit">Update movie</button>
                            <a href="deleteTvShow.jsp?id=<%=resultSet.getInt("id") %>" class="btn btn-danger" type="submit">Delete movie</a>
                        </div>
                    </form> 
                </div>
            </div>
        </div>
    </body>
</html>
