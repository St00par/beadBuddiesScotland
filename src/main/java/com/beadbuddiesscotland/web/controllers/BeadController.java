package com.beadbuddiesscotland.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beadbuddiesscotland.web.models.BeadModel;
import com.beadbuddiesscotland.web.services.BeadService;

	@RestController
	public class BeadController {
		
		@Autowired
		public BeadService service;

			@GetMapping("/newJewellery")
			public BeadModel addNewJewellery() {
				return new BeadModel(129.99, "Wood", "Bracelet", "img5.jpg");
			}
			
			@GetMapping("/read")
			public List<BeadModel> readAll() {
				return this.service.read();
			}
			
			@GetMapping("/getAll")
			public ResponseEntity<List<BeadModel>> getAll() {
				return new ResponseEntity<List<BeadModel>>(this.service.readAll(), HttpStatus.OK);
			}
			
			@PostMapping("/create")
			public ResponseEntity<BeadModel> create(@RequestBody BeadModel jewellery) {
				return new ResponseEntity<BeadModel>(this.service.create(jewellery), HttpStatus.CREATED);
			}
			
			@PutMapping("/update/{id}")
			public ResponseEntity<BeadModel> update(@PathVariable("id") int id, @RequestBody BeadModel jewellery) {
				return new ResponseEntity<BeadModel>(this.service.update(id, jewellery), HttpStatus.ACCEPTED);
			}
			
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<Boolean> update(@PathVariable int id) {
				return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
			}
}

