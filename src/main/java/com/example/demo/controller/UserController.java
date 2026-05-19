package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entiry.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	private final UserRepository userRepository;

	public UserController(
			UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	@GetMapping("users/new")

	//新規登録画面
	public String Create() {
		return "newUser";
	}

	@PostMapping("users/add")

	public String add(
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String password,
			Model model) {

		User user = new User(name, password);

		userRepository.save(user);

		return "redirect:/login";

	}

	@GetMapping({ "/", "/login" })

	//ログイン画面
	public String index() {
		return "login";
	}

	@PostMapping("/login")

	//ログイン実行
	public String login(
			@RequestParam String name,
			@RequestParam String password,
			Model model) {

		if (name == null && password == null) {
			model.addAttribute("message", "名前とパスワードを入力してください");

			return "login";
		}

		return "";
	}
}