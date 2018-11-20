package com.piIotSpringApi.piSpring.repository;

import com.piIotSpringApi.piSpring.model.AccelerometerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AccelDataRepository extends JpaRepository<AccelerometerData, Long>  {
}
