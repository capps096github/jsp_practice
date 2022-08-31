<%@ page import="static java.lang.System.out" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.http.HttpResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student JSP Here</title>
</head>
<body>
<h1>Student JSP Here</h1>


<%!
    int num =9;
    int sum(String calcName){
        int plusNum = ++num;
        int numPlus = num++;

        // print ++num
        out.println(calcName);
        out.println("++num = " + plusNum);
        out.println("num++ = " + numPlus);

        return plusNum+numPlus;
    }

    int all(){
        int n1= sum("n1");
        int n2= sum("n2");
        return n1+n2;
    }
%>
The first Computation is <%=sum("first")  %><br>
The second computation is <%=sum("second 1")-sum("second 2")  %> <br>
<%-- int num=1;  --%>
Lastly <% out.println(" There "+all());%>

<%!%>
</body>
</html>


