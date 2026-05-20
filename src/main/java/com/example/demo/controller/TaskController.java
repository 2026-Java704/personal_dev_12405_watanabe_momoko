package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.RecordsRepository;

public class TaskController {

	private final RecordsRepository recordsRepository;

	public TaskController(
			RecordsRepository recordsRepository) {
		this.recordsRepository = recordsRepository;
	}

	@GetMapping("/records/add")
	public String index() {
		return "records";
	}

	//	@PostMapping("/records/add")
	//		public String enter(
	//				@RequestParam Integer time,
	//				@RequestParam )
	//		
}
