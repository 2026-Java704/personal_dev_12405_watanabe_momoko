package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Exercise_records;

public interface Exercise_recordsRepository extends JpaRepository<Exercise_records, Integer> {
	List<Exercise_records> findByUserIdOrderByDateDescIdDesc(Integer userId);

	@Query("SELECT SUM(record.burnCalorie) FROM Exercise_records record")
	int getTotalBurnCalorie();

}
