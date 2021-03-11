<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 	<%@ page import = "java.util.* , com.ltts.model.* , com.ltts.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Players</title>
</head>
<body>

<% PlayerDAO pd=new PlayerDAO();
Player p = new Player();
int a = p.getPlayerId();
List<Player> li=pd.getAllPlayers();

%>
<!--
<table>
<tr>
<th>Player ID</th>
<th>Player Name</th>
<th>Player DOB</th>
<th>Player Skill</th>
<th>Player No Of Matches</th>
<th>Player Runs</th>
<th>Player Bowled</th>
<th>Player Nationality</th>
<th>Player Power Rating</th>
<th>Player Team ID</th>
</tr>
<h1>body</h1>
-->
<% System.out.print("Abc"); %>
<%
for(Player p1:li){%>

	<tr>
	<td><%=a %>
	
	</tr>
	
<% }%>

<h3>outside</h3>
</table>
</body>
</html>
