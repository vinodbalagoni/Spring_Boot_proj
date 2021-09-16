package net.javaguides.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.Repository.bookRepository;
import net.javaguides.springboot.Repository.studentRepository;
import net.javaguides.springboot.entity.Book;
import net.javaguides.springboot.entity.Student;


@RestController
@RequestMapping("api/v1")
public class bookController {

	@Autowired
	private bookRepository  repository;
	 @GetMapping("/books")
	    public List<Book> getAllStudents() {
	        return repository.findAll();
}
}
