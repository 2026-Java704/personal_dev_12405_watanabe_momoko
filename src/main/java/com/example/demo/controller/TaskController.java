package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entiry.Events;
import com.example.demo.entiry.Records;
import com.example.demo.repository.EventsRepository;
import com.example.demo.repository.RecordsRepository;

@Controller
public class TaskController {

	private final RecordsRepository recordsRepository;
	private final EventsRepository eventsRepository;

	public TaskController(
			RecordsRepository recordsRepository,
			EventsRepository eventsRepository) {
		this.recordsRepository = recordsRepository;
		this.eventsRepository = eventsRepository;
	}

	@GetMapping("/records/add")
	public String index() {
		return "records";
	}

	@PostMapping("/records/add")
	public String enter(
			@RequestParam Integer time,
			@RequestParam Integer weight,
			@RequestParam Date date,

			Model model) {

		List<Events> eventList = eventsRepository.findAll();
		model.addAttribute("records", eventList);

		Records records = new Records(time, weight, date);
		model.addAttribute("records", records);

		return "resault";
	}
}
