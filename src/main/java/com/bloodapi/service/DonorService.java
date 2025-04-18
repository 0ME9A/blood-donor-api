package com.bloodapi.service;

import com.bloodapi.model.Donor;
import com.bloodapi.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Import the Transactional annotation

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public DonorRepository getDonorRepository() {
        return donorRepository;
    }

    public Donor addDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public List<Donor> getDonorsByBloodGroupAndCity(String bloodGroup, String city) {
        return donorRepository.findByBloodGroupAndCity(bloodGroup, city);
    }

    public List<Donor> getDonorsByPhone(String phone) {
        return donorRepository.findByPhone(phone);
    }

    public List<Donor> getDonorsByName(String name) {
        return donorRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Donor> getDonorsByGender(String gender) {
        return donorRepository.findByGender(gender);
    }

    // Find donors by age range
    public List<Donor> getDonorsByAgeRange(int minAge, int maxAge) {
        return donorRepository.findByAgeBetween(minAge, maxAge);
    }

    // Find donors by specific ages
    public List<Donor> getDonorsByAges(List<Integer> ages) {
        return donorRepository.findByAgeIn(ages);
    }

    // Delete dodnor by id
    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }

    @Transactional // Add this annotation
    public void deleteDonors(List<Long> ids) {
        donorRepository.deleteByIdIn(ids);
    }
}