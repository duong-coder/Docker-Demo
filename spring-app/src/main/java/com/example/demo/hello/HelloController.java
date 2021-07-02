package com.example.demo.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private HelloRepository helloRepository;
	
	@GetMapping("/hello")
	public People hello() {
		List<People> list =	helloRepository.findAll();
		System.out.println(list.get(0).toString());
		return list.get(0);
	}
	
	@GetMapping("/people")
	public List<People> getPeople() {
		List<People> list =	helloRepository.findAll();
		System.out.println(list.get(0).toString());
		
		return list;
	}
}
