package helloworld.servlets;

import helloworld.foo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletNumber1 extends HttpServlet implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private String staticMessage = "THIS IS ALWAYS HERE";
	private String sessionId;
	{
		this.message = "default value";
	}
     public void init(ServletConfig config) throws ServletException {            /*#2*/
         super.init(config);
         this.message = config.getInitParameter("message");                      /*#3*/
     }
     
     public void doGet(HttpServletRequest request, HttpServletResponse response) /*#4*/
	 throws IOException, ServletException
      {
    	 this.sessionId = request.getSession().getId() + " and " + request.getSession().toString();
         ServletContext servletContext = getServletConfig().getServletContext();
         servletContext.setAttribute("foo","bar");
         String foo = (String) servletContext.getAttribute("foo");
         
         User aUser = new User();
         request.setAttribute("user", aUser);
         
         User bUser = new User();
         bUser.setUserName("Slim Shady");
         
         
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();                                 /*#5*/
         out.println("<html>");
         out.println("<head>");
         out.println("<title>" + this.message + "</title>");                     /*#6*/
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Hello World!</h1>");
         out.println("session attrib is " + foo);
         out.println(" <p><b>session info is: " + sessionId + "</b></p>");
         out.println("</body>");
         out.println("</html>");
      }
     public String getMessage(){
    	 return this.message;
     }
     public String getStaticMessage(){
    	 return this.staticMessage;  /*still does not give me anything*/
    	 //return "and if you don\'t know, now you know";
     }
     public String getSessionId(){
    	 return this.sessionId;
     }
}
