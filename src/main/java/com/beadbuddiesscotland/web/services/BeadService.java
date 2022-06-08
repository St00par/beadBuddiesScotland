package com.beadbuddiesscotland.web.services;

import java.util.List;

import com.beadbuddiesscotland.web.models.BeadModel;

public interface BeadService {
	
	public List<BeadModel> readAll();
	public List<BeadModel> read();
	public BeadModel create(BeadModel jewellery);
	public BeadModel update(int id, BeadModel jewellery);
	public Boolean delete(int id);

}
