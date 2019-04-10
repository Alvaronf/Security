package es.softtek.jwtDemo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		return "Hello " + name + "!!";
	}

	@RequestMapping("logout")
	public class LogoutController1 extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

			HttpSession session = request.getSession(false);

			if (session != null) {

				session.invalidate();
				session = null;
			}
			try {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
