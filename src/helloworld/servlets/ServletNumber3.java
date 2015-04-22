package helloworld.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(                                                                    /*#1*/
        name = "helloWorldServlet3",                                             /*#2*/
        urlPatterns = {"/hello3.html"},                                          /*#3*/
        initParams = {                                                          /*#4*/
                @WebInitParam(name="message", value="Hello 3niverse!")          /*#5*/
        }
)

public class ServletNumber3 extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
   
	public void init(ServletConfig config) throws ServletException {           /* #2*/
         super.init(config);
         this.message = config.getInitParameter("message");                      /*#3*/
     }
	
     public void doGet(HttpServletRequest request, HttpServletResponse response) /*#4*/
     throws IOException, ServletException
      {
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();                                 /*#5*/
          out.println("<html>");
          out.println("<head>");
          out.println("<title>" + this.message + "</title>");                     /*#6*/
          out.println("</head>");
          out.println("<body>");
          out.println("<h1>Hello World!</h1>");
          out.println("</body>");
          out.println("</html>");
      }
}