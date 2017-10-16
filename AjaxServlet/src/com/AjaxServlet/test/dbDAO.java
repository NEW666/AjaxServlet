package com.AjaxServlet.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbDAO {
	
	private Connection con;
	
	//连接数据库
	
	public dbDAO() throws Exception{
		
		String dburl = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useOldAliasMetadataBehavior=true";
		
		String dbuername= "root";
		String dbpas = "960620";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		this.con = DriverManager.getConnection(dburl,dbuername,dbpas);
	}
	
	public ResultSet query(String sql,Object... args) throws Exception{
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		for(int i=0;i< args.length; i++)
		{
			ps.setObject(i+1,args[i]);
			
		}
		return ps.executeQuery();
		
	}
	
	public boolean insert (String sql,Object... args) throws SQLException{
		PreparedStatement ps = con.prepareStatement(sql);
		for(int i=0;i<args.length;i++)
		{
			ps.setObject(i+1,args[i]);
			
			
		}
		
		if(ps.executeUpdate()!= 1)
		{
			return false;
		}
		
		return true;
	}
	
	
	public boolean modify(String sql,Object... args) throws Exception{
		PreparedStatement ps = con.prepareStatement(sql);
		
		for(int i=0;i<args.length;i++)
		{
			ps.setObject(i+1, args[i]);
		}
		if(ps.executeUpdate() != 1)
		{
			return false;
		}
		
		return true;
	}
	
	protected void finalize() throws Exception{
		if(!con.isClosed() || con !=null)
		{
			con.close();
		}
	}

}
