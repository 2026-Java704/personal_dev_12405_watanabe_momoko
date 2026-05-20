package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entiry.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	private final UserRepository userRepository;
	private final HttpSession session;
	private final Account account;

	public UserController(
			UserRepository userRepository,
			HttpSession session,
			Account account) {

		this.userRepository = userRepository;
		this.session = session;
		this.account = account;
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

	@GetMapping({ "/", "/login", "/logout" })

	//ログイン画面
	public String index() {

		session.invalidate();
		return "login";
	}

	@PostMapping("/login")

	//ログイン実行
	public String login(
			@RequestParam String name,
			@RequestParam String password,
			Model model) {

		if (name.length() == 0 || password.length() == 0) {
			model.addAttribute("message", "入力してください");
			return "login";
		}

		List<User> userList = userRepository.findByNameAndPassword(name, password);

		if (userList.size() == 0) {
			model.addAttribute("message", "名前とパスワードが一致しません");
			return "login";
		}

		account.setName(name);

		return "redirect:/records/add";
	}

}