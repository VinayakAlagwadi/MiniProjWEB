<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
    <%@ page import = "com.ltts.model.Player" %>
    <%@ page import = "com.ltts.dao.PlayerDAO" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW ALL PLAYERS JSP FILE</title>
</head>
<body>
<% PlayerDAO pd=new PlayerDAO();
List<Player> li=pd.getAllPlayers();%>
<table>
<tr>
<th>Player ID</th>
<th>Player Name</th>
<th>Player DOB</th>
<th>Player Skill</th><th>Player No Of Matches</th>
<th>Player Runs</th>
<th>Player Bowled</th>
<th>Player Nationality</th>
<th>Player Power Rating</th>
<th>Player Team ID</th>

</tr>
<%
for(Player p1:li){%>

	
	<tr>
	<td><%=p1.getPlayerId() %></td>
	<td><%=p1.getName() %>	</td>
	<td><%=p1.getDateOfBirth() %></td>
	<td><%=p1.getSkill() %></td>
	<td><%=p1.getNumberOfMatches() %></td>
	<td><%=p1.getRuns() %></td>
	<td><%=p1.getWickets() %></td>
	<td><%=p1.getNationality() %></td>
	<td><%=p1.getPowerRating() %></td>
	<td><%=p1.getTeamId() %></td><br><br>
	<td><a href="editplayer.jsp?id=<%=p1.getPlayerId()%>">Update Player</a></td>
	</tr>
<%} %>

</table>
</body>
</html>