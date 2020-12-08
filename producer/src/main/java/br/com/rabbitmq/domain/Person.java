package br.com.rabbitmq.domain;

import java.time.LocalDate;

public class Person {
	
	private String name;
	private Integer collegeCompletedYear;
	private LocalDate dateOfBirth;
	private Boolean active;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCollegeCompletedYear() {
		return collegeCompletedYear;
	}
	
	public void setCollegeCompletedYear(Integer collegeCompletedYear) {
		this.collegeCompletedYear = collegeCompletedYear;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}

}
