package net.javaguides.springboot.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
 
import net.javaguides.springboot.entity.Cource;

public interface courceRepository extends JpaRepository<Cource, Long> {

}
