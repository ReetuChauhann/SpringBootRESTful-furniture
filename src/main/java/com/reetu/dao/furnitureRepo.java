package com.reetu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Furniture;

@Repository
public class furnitureRepo {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	//add furniture
	public String add(Furniture f, MultipartFile image) {
		try {
			String query="insert into fdata values(?,?,?,?)";
			int x=jdbctemplate.update(query, new Object[] {f.getName(), f.getPrice(), f.getType(), image.getInputStream()});
			if(x!=0) {
				return "success";
			}else {
				return "failed";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
		}
	}
	
	//get all furniture
	public List<Furniture> getall(){
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Furniture f=new Furniture();
				f.setName(rs.getString("name"));
				f.setPrice(rs.getString("price"));
				f.setType(rs.getString("type"));
				return f;
			}

		}
		try {
			final String query="select * from fdata";
			List<Furniture> f= jdbctemplate.query(query, new DataMapper());
			return f;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	//get Furniture by name
	public Furniture getfurniturebyname(String name) {
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Furniture f=new Furniture();
				f.setName(rs.getString("name"));
				f.setPrice(rs.getString("price"));
				f.setType(rs.getString("type"));
				return f;
			}
			
		}
		try {
			final String query="select * from fdata where name=?";
			Furniture f=(Furniture) jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {name});
			return f;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	//get image
	public byte[] getimage(String name) {
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getBytes("image");
			}
			
		}
		try {
			final String query="select image from fdata where name=?";
			byte[] b= (byte[])jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {name});
			return b;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	//delete by name
	public String deletebyname(String name) {
		try {
			String query="delete from fdata where name=?";
			int x=jdbctemplate.update(query, new Object[] {name});
			if(x!=0) {
				return "success";
			}else {
				return "failed";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
		}
	}
	
	//update furniture
	public String update(Furniture f, MultipartFile image) {
		  try {
			String query="update fdata set price=?,type=?,image=? where name=?";
			int x= jdbctemplate.update(query, new Object[] {f.getPrice(), f.getType(), image.getInputStream(), f.getName()});
			if(x!=0) {
				return "success";
			}else {
				return "failed";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
		}
	}
	
	//get all name only
	public List<String> getallname(){
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("name");
			}
		}
		try {
			final String query="select * from fdata";
			List<String> f=jdbctemplate.query(query, new DataMapper());
			return f;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	//get all same type
	public List<Furniture> getsametype(String type){
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Furniture f=new Furniture();
				f.setName(rs.getString("name"));
				f.setPrice(rs.getString("price"));
				f.setType(rs.getString("type"));
				return f;
			}
			
		}
		try {
			final String query="select * from fdata where type like?";
			List<Furniture> f= jdbctemplate.query(query, new DataMapper(), new Object[] {"%"+type+"%"});
			return f;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
