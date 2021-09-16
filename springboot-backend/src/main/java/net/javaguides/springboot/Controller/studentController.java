package net.javaguides.springboot.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.javaguides.springboot.Repository.studentRepository;
import net.javaguides.springboot.entity.Student;
 
@RestController
@RequestMapping("api/v1")
public class studentController { 
	
	HashMap<Long, Student> map=new HashMap<Long, Student>(); 
	Long i=(long) 1;
	@Autowired
	private studentRepository  repository;
	
	 @GetMapping("/students")
	    public List<Student> getAllStudents() {
		 List<Student> std = new ArrayList<>();
		 Student std1 = new Student();
		 if(!(map.isEmpty())) {
			 for(Map.Entry m : map.entrySet()) {
				 
				 ObjectMapper mapper = new ObjectMapper();
			        Student user = mapper.convertValue(m.getValue(), Student.class);
				  user.setId((Long) m.getKey());
				 std.add(user);
			 }
			   
			 return std;
		 }else {
			 return repository.findAll();
		 }
	        
	    }
	 @GetMapping("/student/{id}")
	    public Student getAllStudent(@PathVariable("id") Long id) {
		 if(map.get(id)!=null) {
			 
			Student value =map.get(id);
			 ObjectMapper mapper = new ObjectMapper();
		     Student user = mapper.convertValue(((Entry) value).getValue(), Student.class);
			 user.setId((Long)((Entry) value).getKey());
			 
			 return  user;
		 }else {
			 return repository.findById(id).orElse(null);
		 }
	        
	    }
	 @PostMapping("student")
	 public Student saveStudent(@RequestBody Student student) {
		 map.put(i++,new Student(student.getFirstName(),student.getLastName()));
		 System.out.println("Mappings of HashMap hm1 are : "
                 + map);
		 return repository.save(student);
	 }
	 
	 @PutMapping("student/{id}")
	 public  ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,@RequestBody Student student) {
		 
		 Student student1 = repository.findById(id).orElse(null);
		 if(student1==null) {
			 return ResponseEntity.notFound().build();
		 }
		 
		 student1.setFirstName(student.getFirstName());
		 student1.setLastName(student.getLastName());
		 map.put(id,new Student(student1.getFirstName(),student1.getLastName()));
		 System.out.println("Student data update"+map);
		 Student udatedStudent = repository.save(student1);
		 
		 return ResponseEntity.ok(udatedStudent); 
	 
	 }
	 
  @DeleteMapping("student/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Student student = repository.findById(id)
				.orElse(null);
		map.remove(id);
		 System.out.println("Student data after delete"+map);
		repository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
  @GetMapping("/studentData")
  public HashMap<Long, Student> getAllStudentData() {
	return map;
	 
  } 
	 
	 
	 
}
