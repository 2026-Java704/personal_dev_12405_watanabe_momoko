package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entiry.Records;

public interface RecordsRepository extends JpaRepository<Records, Integer> {

}
