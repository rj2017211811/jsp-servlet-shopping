//����������Ҫ��ɶ��û���ݵ���֤
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


import model.*;

public class LoginDealServlet extends HttpServlet{
	
		public void init() {
			//���ļ���ȡ�����ʴ���
			FileReader f = null;
			try {
				f = new FileReader("C:\\Users\\���ſƼ�\\workspace\\.metadata\\TestShopping\\WebContent\\test.txt");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			BufferedReader br=new BufferedReader(f);
			String str = null;
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Ϊ���ʴ�������ServletContext
			this.getServletContext().setAttribute("times",str);
			try {
				br.close();
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


		public void destroy() {
			//��ServletContext�з��ʴ�����ֵд���ļ�
		
			ServletContext sc=this.getServletContext();
			String str=(String) sc.getAttribute("times");
			int times=Integer.parseInt(str);
			FileWriter f = null;
			
			try {
				f = new FileWriter ("C:\\Users\\���ſƼ�\\workspace\\.metadata\\TestShopping\\WebContent\\test.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			BufferedWriter br=new BufferedWriter(f);
		
			try {
				 br.write(str);
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

		}

		

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pw.println(1);
		
		String flag=request.getParameter("flag");
	//	pw.println(flag);
		if(flag.equals("login"))
		{
			//pw.println(2);
			String username=request.getParameter("username");
	        String password=request.getParameter("password");
			
	        UserBean u=new UserBean(username,password);
	        UserBeanDeal userDeal=new UserBeanDeal();
	        
	        
	        try {
				if(userDeal.checkUser(u))
				{
					
					//����cookie
					String keep=request.getParameter("keep");
					if(keep!=null)
					{
						
						
						 Cookie usernames=new Cookie("username",username);
						    usernames.setMaxAge(24*60);
						    response.addCookie(usernames);
						
						
					}
					//����session
					HttpSession session=request.getSession(true);
					session.setAttribute("username", username);
					//����session��ʱ��
					//session.setMaxInactiveInterval(25);
					
					//ServletContext�з��ʴ�����һ
					String strTimes=(String) this.getServletContext().getAttribute("times");
					int times=Integer.parseInt(strTimes);
					times++;
					pw.println(times);
					this.getServletContext().setAttribute("times", Integer.toString(times));
					
					//��ת��UserBeanDealServlet��������ȡpageCount��userList
					request.getRequestDispatcher("GoodsDealServlet?pageNow=1&flag=dividePage").forward(request, response);
					pw.println("��¼�ɹ���");
				}
				else
				{
					//res.sendRedirect("login.jsp");
					//��ΪsendRedirect����Ч�ʲ��ߣ����������˾����ת������
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(flag.equals("exit"))
		{
			//pw.println(3);
			
			try {
				pw = response.getWriter();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//pw.println(1);
			//����cookie
			Cookie[]cookies=request.getCookies();
			for(int i=0;i<cookies.length;i++)
			{
				//pw.println(cookies[i]);
				//�ҵ���Ϊusername��cookie
				if(cookies[i].getName().equals("username"))
				{
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					//pw.println(cookies[i]);
				}
				
				
			}
			HttpSession hs=request.getSession();
			hs.removeAttribute("username");
			try {
				request.getRequestDispatcher("website/login.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
        
        
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		this.doGet(req,res);
		
	}
}