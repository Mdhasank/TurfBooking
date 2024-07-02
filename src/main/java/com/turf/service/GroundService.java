package com.turf.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.turf.enities.Ground;



public interface GroundService {
	
	public Ground saveGround(Ground ground);
	
	public List<Ground> getAllGround();
	
	public Ground getGroundById(int id);
	
	public Ground updateGround(Ground ground,MultipartFile file);
	
	public boolean deleteGround(int id);
	
	public List<Ground> getAllActiveGrounds(String category);
	
	

}
