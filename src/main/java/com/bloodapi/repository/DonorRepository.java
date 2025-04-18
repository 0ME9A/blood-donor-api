package com.bloodapi.repository;

import com.bloodapi.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
// import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> { // Changed Integer to Long

    // find donor by blood group and city
    List<Donor> findByBloodGroupAndCity(String bloodGroup, String city); // Changed bloodString to bloodGroup for

    // find donor by phone number
    List<Donor> findByPhone(String phone);

    // find donor by name
    List<Donor> findByNameContainingIgnoreCase(String name); // Changed method name

    // find donor by gender
    List<Donor> findByGender(String gender);

    // Find donors within an age range
    List<Donor> findByAgeBetween(int minAge, int maxAge);

    // Find donors with specific ages using a custom query with IN clause
    @Query("SELECT d FROM Donor d WHERE d.age IN :ages")
    List<Donor> findByAgeIn(@Param("ages") List<Integer> ages);

    // delete many donor
    void deleteByIdIn(List<Long> ids); // Method to delete multiple donors by a list of IDs

}