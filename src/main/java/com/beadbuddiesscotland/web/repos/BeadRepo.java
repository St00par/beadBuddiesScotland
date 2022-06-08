package com.beadbuddiesscotland.web.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beadbuddiesscotland.web.models.BeadModel;

public interface BeadRepo extends JpaRepository<BeadModel, Integer> {

}
