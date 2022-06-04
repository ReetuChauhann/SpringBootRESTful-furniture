package com.reetu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Furniture;
import com.reetu.dao.furnitureRepo;

@Service
public class ServiceImpl implements MyService {
	@Autowired
	furnitureRepo fr;

	@Override
	public String add(Furniture f, MultipartFile image) {
		// TODO Auto-generated method stub
		return fr.add(f, image);
	}

	@Override
	public List<Furniture> getall() {
		// TODO Auto-generated method stub
		return fr.getall();
	}

	@Override
	public Furniture getfurniturebyname(String name) {
		// TODO Auto-generated method stub
		return fr.getfurniturebyname(name);
	}

	@Override
	public byte[] getimage(String name) {
		// TODO Auto-generated method stub
		return fr.getimage(name);
	}

	@Override
	public String deletebyname(String name) {
		// TODO Auto-generated method stub
		return fr.deletebyname(name);
	}

	@Override
	public String update(Furniture f, MultipartFile image) {
		// TODO Auto-generated method stub
		return fr.update(f, image);
	}

	@Override
	public List<String> getallname() {
		// TODO Auto-generated method stub
		return fr.getallname();
	}

	@Override
	public List<Furniture> getsametype(String type) {
		// TODO Auto-generated method stub
		return fr.getsametype(type);
	}

}
