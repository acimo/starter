<%@ page import="java.util.Calendar" %> 
<%@ page import="helloworld.servlets.*" %> 
<%@ page import="helloworld.foo.User" %>
<%! User aUser = new User();  %>
<html>
 <head>
     <title>Apress Demo</title>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
<body>
	<% 
		application.setAttribute("user", new User());
		request.setAttribute("servletNumber1", servletNumber1Factory());
	%>
	<%! public ServletNumber1 servletNumber1Factory() {return new ServletNumber1();}%>
<%-- 	${application.setAttribute("servletNumber1", servletNumber1Factory())} --%>
     <div class="content">
         <b>Welcome to Apress</b>

         <p>Today is <%=Calendar.getInstance().getTime()%>                      <!-- #2 -->
         </p>
         <%
             String greeting;                                                   /* #3 */
             int hourOfDay = 
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
             if (hourOfDay < 12) {
                 greeting = "Good Morning";
             } else if (hourOfDay >= 12 && hourOfDay < 19) {
                 greeting = "Good Afternoon";
             } else {
                 greeting = "Good Evening";
             }

         %>
         <p><%=greeting%></p>                                                   <!-- #4 -->
         <p><b><%out.print("session id is: " + session.getId()); %></b></p>
         <p><b>It is:${servletNumber1.message}</b></p> <!-- nothing prints -->
         <p><b>It is:${servletNumber1.staticMessage}</b></p> <!-- nothing prints -->
         <p><b>It is:${servletNumber1.getStaticMessage()}</b></p> <!-- nothing prints -->
         <p><b>It is:${user.userName}</b></p> <!-- prints "Bob" because of 'application.setAttribute()' above (in this same file -->
         <p><b>It is:${aUser.userName}</b></p> <!-- nothing prints -->
     </div>
 </body>
 </html>