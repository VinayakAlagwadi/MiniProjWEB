<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import ="java.util.*,com.ltts.model.*,com.ltts.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Player</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
PlayerDAO pd=new PlayerDAO();
Player p1=pd.getPlayerById(id);
%>
<form action="./UpdatePlayerServlet" method="post">
Player Id: <input type="hidden" value = "<%=p1.getPlayerId() %>" name = "pno"> <br><br>

Player NoOfMatches: <input type="number" value="<%=p1.getNumberOfMatches() %>" name="pmatches"> <br><br>
Player Runs: <input type="number" value="<%=p1.getRuns() %>" name="pruns"> <br><br>
Player Bowled : <input type="number" value="<%=p1.getWickets() %>" name="pwickets"> <br><br>

<input type="submit" value="Update Player">

</form>
</body>
</html>