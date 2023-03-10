package com.electricvehicle.home.model;

import lombok.*;
import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ElectricStation")
public class HomeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long station_id;

    @Column(name = "station_name")
    private String stationName;
    @Lob
    @Column(name = "station_image", nullable = true)
    private String stationImage;
    @Column(name = "station_pricing")
    private Long stationPrice;
    @Column(name = "station_address")
    private String stationAddress;
    
}
