package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.beam;
import com.example.demo.repo.repository;

@RestController
public class pg_controller {
	
	@Autowired
    repository repo;


	@GetMapping("/")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/read")  
    public List<beam> read(){
        return repo.findAll();
    }

    @PostMapping("/insert")
    public beam create(@RequestBody beam rec) {
        return repo.save(rec);

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repo.deleteById(id);
        return "Successfully Deleted";
    }
}

		
