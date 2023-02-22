<%-- 
    Document   : tvshows
    Created on : 21 feb. 2023, 19:08:33
    Author     : Samuel
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TV Shows</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
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
                        <a class="nav-link" href="tvshows.jsp">TV Shows</a>
                        <a class="nav-link" href="">Songs</a>
                    </div>
                </div>
            </div>
        </nav>
        <%
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/MultiMedia", "root", "Admin$1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Shows ORDER BY id ASC");
        %>

        <div class="container" style='margin-top:100px'>
            <div class="card">
                <div class="card-body">
                    <form method="POST" action="saveTvShow.jsp">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-floating mb-3">
                                    <input name="txtId" type="number" class="form-control" placeholder="0">
                                    <label>Id</label>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-floating mb-3">
                                    <input name="txtName" type="text" class="form-control" placeholder="Name">
                                    <label>Name</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-floating mb-3">
                                    <input name="txtEpisodes" type="number" class="form-control" placeholder="0">
                                    <label>Episodes</label>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-floating mb-3">
                                    <input name="dateRelease" type="date" class="form-control" placeholder="Date">
                                    <label>Date</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-floating mb-3">
                                    <select class="form-select" name="ddGenre">
                                        <option value="Drama" selected>Drama</option>
                                        <option value="Thriller">Thriller</option>
                                        <option value="Terror">Terror</option>
                                        <option value="Comedy">Comedy</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-floating mb-3">
                                    <select class="form-select" name="ddCountry">
                                        <option value="USA" selected>USA</option>
                                        <option value="Mexico">Mexico</option>
                                        <option value="Canada">Canada</option>
                                        <option value="Europe">Europe</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div style="float:right">
                            <button type="submit" class='btn btn-success'>Add TV Show</button>
                        </div>
                    </form>
                </div>
            </div>
            <hr>  
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Episodes</th>
                        <th scope="col">Date</th>
                        <th scope="col">Genre</th>
                        <th scope="col">Country</th>
                    </tr>
                </thead>
                <tbody>
                    <% while (resultSet.next()) {%>
                    <tr>
                        <td><%=resultSet.getString("id")%></td>
                        <td><%=resultSet.getString("name")%></td>
                        <td><%=resultSet.getString("episodes")%></td>
                        <td><%=resultSet.getString("date")%></td>
                        <td><%=resultSet.getString("genre")%></td>
                        <td><%=resultSet.getString("country")%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
