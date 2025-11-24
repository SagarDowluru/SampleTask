package com.awsdemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsDemoController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@GetMapping("/go")
	public String getAccess() {
	
		return "Working fine.....!";	
	}
	
	
	@GetMapping("/getemployeedata/{id}")
	
	public List<Map<String,Object>> getData(@PathVariable int id){
		
		List<Map<String,Object>> data= new ArrayList<>();
		Map<String , Object> empdata= new HashMap<>();
		String sql = "select * from emp_data where ID = ?";
		data= jdbcTemplate.queryForList(sql, id);
		if(data.isEmpty()) {
			empdata.put("No data available on given ID", id);
			data.add(empdata);
		}
		return data;		
	}
	
@GetMapping("/getemployeedata")
	
	public List<Map<String,Object>> getAllData(){
		
		List<Map<String,Object>> data= new ArrayList<>();
		Map<String , Object> empdata= new HashMap<>();
		String sql = "select * from emp_data";
		data= jdbcTemplate.queryForList(sql);
		
		return data;		
	}

@GetMapping("/checkpoint")

public String checkPoint(){
	
	String data = "Employee data";
	
	return data;		
}
	
	
	
}
