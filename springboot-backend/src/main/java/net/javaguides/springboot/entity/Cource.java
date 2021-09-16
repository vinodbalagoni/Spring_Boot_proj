package net.javaguides.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cource {
    
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Cource() {
		
	}

	public Cource(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cource [id=" + id + ", name=" + name + "]";
	}
	
}
