package com.electricvehicle.home.repository;

import com.electricvehicle.home.model.HomeModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<HomeModel, Long> {

}
