package com.bloodapi.controller;

import com.bloodapi.model.Donor;
import com.bloodapi.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/donors")
@CrossOrigin
public class DonorController {

    @Autowired
    private DonorService donorService;

    @PostMapping
    public Donor addDonor(@RequestBody Donor donor) {
        return donorService.addDonor(donor);
    }

    @GetMapping
    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Donor>> getDonorsByName(@PathVariable String name) {
        List<Donor> donors = donorService.getDonorsByName(name);
        if (donors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(donors);
    }

    // Filter by bood group and city
    @GetMapping("/search")
    public ResponseEntity<List<Donor>> getByBloodGroupAndCity(
        @RequestParam String bloodGroup,
        @RequestParam String city
    ){
        List<Donor> donors = donorService.getDonorsByBloodGroupAndCity(bloodGroup, city);
        if(donors.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(donors);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<List<Donor>> getDonorsByPhone(@PathVariable String phone) { // Changed return type to
        // ResponseEntity<List<Donor>>
        List<Donor> donors = donorService.getDonorsByPhone(phone);
        if (donors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(donors);
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Donor>> getDonorByGender(@PathVariable String gender) {
        List<Donor> donors = donorService.getDonorsByGender(gender);
        if (donors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(donors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long id) {
        Optional<Donor> donor = donorService.getDonorRepository().findById(id);
        return donor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // Changed int to Long
    public void deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
    }

    // DELETE: Delete multiple donors
    @DeleteMapping("/delete-many")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDonors(@RequestBody List<Long> ids) {
        donorService.deleteDonors(ids);
    }

    @GetMapping("/age/{ageCriteria}")
    public ResponseEntity<List<Donor>> getDonorsByAge(@PathVariable String ageCriteria) {
        if (ageCriteria.contains("-")) {
            // Handle age range: /api/donors/age/18-28
            String[] range = ageCriteria.split("-");
            if (range.length == 2) {
                try {
                    int minAge = Integer.parseInt(range[0]);
                    int maxAge = Integer.parseInt(range[1]);
                    List<Donor> donors = donorService.getDonorsByAgeRange(minAge, maxAge);
                    return ResponseEntity.ok(donors);
                } catch (NumberFormatException e) {
                    return ResponseEntity.badRequest().body(null); // Corrected: Returning null for List<Donor> body
                }
            } else {
                // Handle multiple specific ages (including cases with more than one hyphen)
                try {
                    List<Integer> ages = Arrays.stream(ageCriteria.split("-"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    if (!ages.isEmpty()) {
                        List<Donor> donors = donorService.getDonorsByAges(ages);
                        return ResponseEntity.ok(donors);
                    } else {
                        return ResponseEntity.badRequest().body(null); // Corrected: Returning null for List<Donor> body
                    }
                } catch (NumberFormatException e) {
                    return ResponseEntity.badRequest().body(null); // Corrected: Returning null for List<Donor> body
                }
            }
        } else {
            // Handle single specific age: /api/donors/age/23
            try {
                int singleAge = Integer.parseInt(ageCriteria);
                List<Donor> donors = donorService.getDonorsByAges(List.of(singleAge));
                return ResponseEntity.ok(donors);
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body(null); // Corrected: Returning null for List<Donor> body
            }
        }
    }
}