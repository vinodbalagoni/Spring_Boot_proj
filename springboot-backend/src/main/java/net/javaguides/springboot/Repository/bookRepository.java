package net.javaguides.springboot.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.entity.Book;

public interface bookRepository extends JpaRepository<Book, Long> {

}
