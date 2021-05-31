<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String driver = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/userdb";
    String database = "userdb";
    String userid = "shanto";
    String password = "123456";
    Class.forName(driver);
    Connection connection = null;
    connection = DriverManager.getConnection(connectionUrl+database, userid, password);
    connection.close();

%>
