package com.bloodapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <-- important
    private Long id;

    private String name;
    private String gender;
    private int age;
    private String bloodGroup;
    private String city;
    private String phone;
    private String lastDonated;

    // getters and setters
}