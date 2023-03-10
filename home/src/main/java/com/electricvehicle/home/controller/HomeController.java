package com.electricvehicle.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.electricvehicle.home.model.HomeModel;
import com.electricvehicle.home.repository.HomeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class HomeController extends BaseController{

    @Autowired
    HomeRepository homeRepository;

    @GetMapping("/")
    public Iterable<HomeModel> findAll() {
        List<HomeModel> stations = new ArrayList<>();
        Iterator<HomeModel> iterator = homeRepository.findAll().iterator();

        iterator.forEachRemaining(station -> {
            station.setStationImage(getApiUrl() + station.getStationImage());
            stations.add(station);
        });
        Collections.reverse(stations);
        return stations;
    }

    @GetMapping("/show/{station_id}")
    public ResponseEntity<HomeModel> findOne(@PathVariable(value = "station_id") long station_id) {
        Optional<HomeModel> stationOptional = homeRepository.findById(station_id);
        if(!stationOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        HomeModel station = stationOptional.get();
        station.setStationImage(getApiUrl() + station.getStationImage());
        return ResponseEntity.ok().body(station);
    }

    @PostMapping("/save")
    public ResponseEntity<HomeModel> create(@Validated @RequestBody HomeModel homeModel) {
        homeModel.setStationImage(homeModel.getStationImage().replace(getApiUrl(), ""));
        HomeModel new_station = homeRepository.save(homeModel);
        return ResponseEntity.ok(new_station);
    }

    @PutMapping("/edit/{station_id}")
    public ResponseEntity<HomeModel> update(@PathVariable(value = "station_id") Long station_id,
                                            @Validated @RequestBody HomeModel homeModel) {
        Optional<HomeModel> stationOptional = homeRepository.findById(station_id);
        if (!stationOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        HomeModel oldStation = stationOptional.get();
        oldStation.setStationName(homeModel.getStationName());
        oldStation.setStationAddress(homeModel.getStationAddress());
        oldStation.setStationPrice(homeModel.getStationPrice());
        oldStation.setStationImage(homeModel.getStationImage().replace(getApiUrl(), ""));

        HomeModel updStation = homeRepository.save(oldStation);
        return ResponseEntity.ok(updStation);
    }

    @DeleteMapping("/delete/{station_id}")
    public ResponseEntity<HomeModel> delete(@PathVariable(value = "station_id") long station_id) {
        Optional<HomeModel> stationOptional = homeRepository.findById(station_id);
        HomeModel station = stationOptional.get();
        if(station == null) {
            return ResponseEntity.notFound().build();
        }
        homeRepository.delete(station);
        return ResponseEntity.ok().build();
    }

}
