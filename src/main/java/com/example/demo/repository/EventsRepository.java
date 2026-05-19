package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entiry.Events;

public interface EventsRepository extends JpaRepository<Events, Integer> {

}
