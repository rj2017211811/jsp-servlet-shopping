package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserBeanDeal;

/**
 * Servlet implementation class RegisterDealServlet
 */
@WebServlet("/RegisterDealServlet")
public class RegisterDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String username=request.getParameter("username");
		username=GoodsDealServlet.getNewString(username);
		pw.println(username);
        String password=request.getParameter("password");
        password=GoodsDealServlet.getNewString(password);
        pw.println(password);
        String truename=request.getParameter("truename");
        truename=GoodsDealServlet.getNewString(truename);
        pw.println(truename);
        String email=request.getParameter("email");
        email=GoodsDealServlet.getNewString(email);
        pw.println(email);
        String phone=request.getParameter("phone");
        
        pw.println(phone);
        String address=request.getParameter("address");
        address=GoodsDealServlet.getNewString(address);
        pw.println(address);
        String postcode=request.getParameter("postcode");
        pw.println(postcode);
        
        UserBean u=new UserBean(username,truename,password,email,phone,address,postcode);
        UserBeanDeal userDeal=new UserBeanDeal();
        try {
			if(userDeal.registerUser(u))
			{
				pw.println("注册成功!");
				request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
			}
			else
			{
				pw.println("该用户名已被注册!");
				request.getRequestDispatcher("registerFailed.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
