package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.Student;

 
 
@Repository
public interface studentRepository extends JpaRepository<Student, Long> {

}
