package net.javaguides.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.Repository.bookRepository;
import net.javaguides.springboot.Repository.courceRepository;
import net.javaguides.springboot.Repository.studentRepository;
import net.javaguides.springboot.entity.Book;
import net.javaguides.springboot.entity.Cource;
import net.javaguides.springboot.entity.Student;


@RestController
@RequestMapping("api/v1")
public class courceController {

	@Autowired
	private courceRepository  repository;
	 @GetMapping("/")
	    public List<Cource> cource() {
	        return repository.findAll();
}
}
