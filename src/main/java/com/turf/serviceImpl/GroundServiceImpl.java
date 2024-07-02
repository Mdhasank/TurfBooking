package com.turf.serviceImpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import com.turf.enities.Ground;
import com.turf.repository.GroundRepository;
import com.turf.service.GroundService;


@Service
public class GroundServiceImpl implements GroundService {
	
	@Autowired
	private GroundRepository groundRepository;

	@Override
	public Ground saveGround(Ground ground) {
		
		return groundRepository.save(ground);
	}

	@Override
	public List<Ground> getAllGround() {
		
		return groundRepository.findAll();
	}

	@Override
	public Ground getGroundById(int id) {
		Ground ground = groundRepository.findById(id).orElse(null);
		return ground;
	}

	@Override
	public Ground updateGround(Ground ground, MultipartFile file) {
		
		Ground dbGround = getGroundById(ground.getId());
		
		String image = file.isEmpty() ? dbGround.getImage() : file.getOriginalFilename();
		
		dbGround.setName(ground.getName());
		dbGround.setDescription(ground.getDescription());
		dbGround.setWidth(ground.getWidth());
		dbGround.setLength(ground.getLength());
		dbGround.setHeight(ground.getHeight());
		dbGround.setPrice(ground.getPrice());
		dbGround.setIsActive(ground.getIsActive());
		dbGround.setCategory(ground.getCategory());
		dbGround.setImage(image);
		
		Ground updateGround = groundRepository.save(dbGround);
		
		if (!ObjectUtils.isEmpty(updateGround)) {
			
			if (!file.isEmpty()) {
				try {
					String uploadDir = "static/img/ground_img";
					
					
					// Create directory if it does not exist
					File directory = new File(uploadDir);
					if (!directory.exists()) {
						directory.mkdirs();
					}

					Path path = Paths.get(uploadDir + File.separator + file.getOriginalFilename());
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
					System.out.println(path);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return ground;
		}
		
		return null;
	}

	@Override
	public boolean deleteGround(int id) {
		
		Ground ground = groundRepository.findById(id).orElse(null);
		
		if (!ObjectUtils.isEmpty(ground)) {
			groundRepository.delete(ground);
			return true;
		}
		return false;
	}

	@Override
	public List<Ground> getAllActiveGrounds(String category) {
		
		List<Ground> grounds = null;
		if (ObjectUtils.isEmpty(category)) {
			grounds = groundRepository.findByIsActiveTrue();
		}else {
			grounds = groundRepository.findByCategory(category);
		}

		return grounds;
	}

}
