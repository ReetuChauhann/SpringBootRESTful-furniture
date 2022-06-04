package com.reetu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Furniture;

public interface MyService {
	public String add(Furniture f, MultipartFile image);
	public List<Furniture> getall();
	public Furniture getfurniturebyname(String name);
	public byte[] getimage(String name);
	public String deletebyname(String name);
	public String update(Furniture f, MultipartFile image) ;
	public List<String> getallname();
	public List<Furniture> getsametype(String type);

}
