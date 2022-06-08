package com.beadbuddiesscotland.web.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beadbuddiesscotland.web.models.BeadModel;
import com.beadbuddiesscotland.web.repos.BeadRepo;

@Service
public class BeadServiceImpl implements BeadService {
	
	@Autowired
	public BeadRepo repo;
	
	@Override
	public List<BeadModel> readAll() {
		return this.repo.findAll();
	}
	
	@Override
	public List<BeadModel> read() {
		List<BeadModel> listOfJewellery = Arrays.asList(new BeadModel(1, 129.99, "Glass", "Necklace", "img1.jpg"),
				new BeadModel(2, 49.99, "Agate", "Bracelet", "img2.jpg"),
				new BeadModel(3, 23.99, "Plastic", "Spider", "img3.jpg"));
		return listOfJewellery;
	}	
	
	@Override
	public BeadModel create(BeadModel jewellery) {
		return this.repo.saveAndFlush(jewellery);
	}
	
	@Override
	public BeadModel update(int id, BeadModel jewellery) {
		BeadModel exists = this.repo.getById(id);
		exists.setType(jewellery.getType());
		exists.setMaterial(jewellery.getMaterial());
		exists.setCost(jewellery.getCost());
		exists.setImage(jewellery.getImage());
		BeadModel updated = this.repo.save(exists);
		return updated;
	}
	
	@Override
	public Boolean delete(int id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
}


