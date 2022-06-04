package com.reetu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Furniture;
import com.reetu.service.MyService;

@RestController
public class Controller {
	@Autowired
	MyService service;
	
	@RequestMapping("/")
	public String home() {
		return "hey honey";
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addfurniture(@RequestPart("Furniture") Furniture f, @RequestPart("image") MultipartFile image){
		String s=service.add(f, image);
		if(s.equals("success")) {
			return new ResponseEntity<String>(s, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(s, HttpStatus.NOT_MODIFIED);
		}
	}
	
	@GetMapping("/getall")
	public List<Furniture> getall(){
		List<Furniture> f=service.getall();
		return f;
	}
	
	@GetMapping("/getsametype/{type}")
	public List<Furniture> getsametype(@PathVariable("type") String type){
		List<Furniture> f=service.getsametype(type);
		return f;
	}

	@GetMapping("/getallname")
	public List<String> getallname(){
		List<String> n= service.getallname();
		return n;
	}
	@GetMapping("/getbyname/{name}")
	public Furniture getbyname(@PathVariable("name") String name) {
		Furniture f=service.getfurniturebyname(name);
		return f;
	}
	
	@RequestMapping("/delete/{name}")
	public String deletenyname(@PathVariable("name") String name) {
		String s=service.deletebyname(name);
		return s;
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestPart("Furniture") Furniture f, @RequestPart("image") MultipartFile image){
		String s=service.update(f, image);
		if(s.equals("success")) {
			return new ResponseEntity<String>(s, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(s, HttpStatus.NOT_MODIFIED);
		}
	}
	
	@GetMapping("/getimage/{name}")
	public byte[] getimage(@PathVariable("name") String name) {
		byte[] b=service.getimage(name);
		return b;
	}
}
