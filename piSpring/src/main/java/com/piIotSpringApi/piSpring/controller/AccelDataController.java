package com.piIotSpringApi.piSpring.controller;

import com.piIotSpringApi.piSpring.exception.ResourceNotFoundException;
import com.piIotSpringApi.piSpring.model.AccelerometerData;
import com.piIotSpringApi.piSpring.repository.AccelDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccelDataController {

    @Autowired
    AccelDataRepository accelDataRepository;

    // Get All Data
    @GetMapping("/data")
    public List<AccelerometerData> getAllData() {
        return accelDataRepository.findAll();
    }

    // Create a new Data Row
    @PostMapping("/data")
    public AccelerometerData createData(@Valid @RequestBody AccelerometerData data) {
        return accelDataRepository.save(data);
    }

    // Get a Single Data Row
    @GetMapping("/data/{id}")
    public AccelerometerData getDataById(@PathVariable(value = "id") Long dataId) {
        return accelDataRepository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Data", "id", dataId));
    }

    // Update a Data Row
    // not needed - just demonstrating the U in CRUD
    @PutMapping("/data/{id}")
    public AccelerometerData updateData(@PathVariable(value = "id") Long dataId,
                           @Valid @RequestBody AccelerometerData dataDetails) {

        AccelerometerData data = accelDataRepository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Data", "id", dataId));

        data.setSerialnumber(dataDetails.getSerialnumber());
        data.setTimestamp(dataDetails.getTimestamp());
        data.setX(dataDetails.getX());
        data.setY(dataDetails.getY());
        data.setZ(dataDetails.getZ());

        AccelerometerData updatedData = accelDataRepository.save(data);
        return updatedData;
    }

    // Delete a Data Row
    // not needed - demonstrating the D in CRUD
    @DeleteMapping("/data/{id}")
    public ResponseEntity<?> deleteData(@PathVariable(value = "id") Long dataId) {
        AccelerometerData data = accelDataRepository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Data", "id", dataId));

        accelDataRepository.delete(data);

        return ResponseEntity.ok().build();
    }

}
