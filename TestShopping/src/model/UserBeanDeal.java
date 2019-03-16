package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserBeanDeal {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private Statement st = null;
	private ResultSet rs = null;

	// 验证用户
	public boolean checkUser(UserBean u) throws Exception {
		boolean flag = false;
		String username = u.getUsername();

		String password = u.getPassword();

		conn = DBtool.getConnection();

		// 创建statement
		st = conn.createStatement();
		rs = st.executeQuery("select password  from users where username='" + username + "'");

		if (rs.next()) {
			String psd = rs.getString(1);
			if (psd.equals(password)) {
				flag = true;
			}

		}
		DBtool.closeResource(conn, null, pst, rs);
		return flag;
	}

	// 用户注册
	public boolean registerUser(UserBean u) throws Exception {
		boolean flag = false;
		String username = u.getUsername();
		conn = DBtool.getConnection();
		// 创建statement
		st = conn.createStatement();
		rs = st.executeQuery("select password  from users where username='" + username + "'");
		if (!rs.next()) {
			
			String sql="insert into users(username,truename,password,email,phone,address,postcode) values(?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getTruename());
			pst.setString(3, u.getPassword());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPhone());
			pst.setString(6, u.getAddress());
			pst.setString(7, u.getPostcode());
			int result=pst.executeUpdate();
			if(result==1)
			{
				flag=true;
			}
		}
		
		
		DBtool.closeResource(conn, null, pst, rs);
		return flag;

	}
    
	
	//显示个人信息
	public List<UserBean> displayUserInfo(UserBean u1)throws Exception
	{
		List<UserBean> userList=new ArrayList<UserBean>();
		String sql="select * from users where username='"+u1.getUsername()+"'";
		conn=DBtool.getConnection();
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next())
		{
			String username= rs.getString(2);
			String truename=rs.getString(3);
			String password=rs.getString(4);
			String email=rs.getString(5);
			String phone=rs.getString(6);
			String address=rs.getString(7);
			String postcode=rs.getString(8);
			UserBean u=new UserBean(username,truename,password,email,phone,address,postcode);
			userList.add(u);
		}
		DBtool.closeResource(conn, pst, pst, rs);
		return userList;
		
		
	}
}