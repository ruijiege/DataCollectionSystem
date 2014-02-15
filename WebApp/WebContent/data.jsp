<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%
	ResultSet rs = (ResultSet) request.getAttribute("rs");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Hackerati Assignment</title>

<script>
		dojoConfig = {
			parseOnLoad : true
		};
	</script>
<script type="text/javascript" src="dojo/dojo.js"
	data-dojo-config="async: true, gfxRenderer: 'svg,silverlight,vml,canvas'"></script>
<script>
		
		require([ "dojox/charting/Chart", "dojox/charting/themes/Tom",
				  "dojox/charting/plot2d/Lines", "dojox/charting/plot2d/Markers",
				  "dojox/charting/axis2d/Default", "dojo/domReady!" ], 
		function(Chart, theme) {
			//var chartData = [{x:1,y:1},{x:2,y:2},{x:3,y:3},{x:4,y:4},{x:5,y:5}];
			var chartData =[];
			<%-- while(<%out.print(rs.next());%>){
				charData.push({x: <%out.print(rs.getString(1));%>, y: <%out.print(rs.getString(2));%>});	
			} --%>		
			<%-- for(var i=0;i<5;i++){
				charData.push({x: <%out.print(rs.getString(1));%>, y: <%out.print(rs.getString(2));%>});
				<% rs.next(); %>
			} --%>
			<%
			int count=1; 
			while (rs.next()) {
				
				out.println("chartData.push({x:" + count + ", y:"
						+ rs.getString(1) + "});");
				count++;
			}%>

 			var chart = new Chart("chartNode");
			chart.setTheme(theme);
			chart.addPlot("default", {
				type : "Lines",
				markers : true
			});
			chart.addAxis("x");
			chart.addAxis("y", {
				min : 0,
				max : 10,
				vertical : true,
				fixLower : "major",
				fixUpper : "major"
			});
			chart.addSeries("SalesThisDecade", chartData);
			chart.render();	
		});
	</script>

</head>







<body>
	<form method="post" action="SelectInterval.do">
		Please select the Interval:
		<p>
			Interval: <select name="interval" size="1">
				<option>second
				<option>minute
				<option>hour
				<option>day
			</select> <input type="submit">
	</form>

	<div id="chartNode" style="width: 800px; height: 100px;"></div>
	<%
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		String ylable = rsmd.getColumnLabel(1);
		String xlable = rsmd.getColumnLabel(2);

		out.println("<h3>Display the table</h3>");
		out.println("<P ALIGN='center'><TABLE BORDER=1>");

		// table header
		out.println("<TR>");
		for (int i = 0; i < columnCount; i++) {
			out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
		}
		out.println("</TR>");
		// the data
		rs.beforeFirst();
		while (rs.next()) {
			out.println("<TR>");
			for (int i = 0; i < columnCount; i++) {
				out.println("<TD>" + rs.getString(i + 1) + "</TD>");
			}
			out.println("</TR>");
		}
		out.println("</TABLE></P>");
	%>
</body>
</html>