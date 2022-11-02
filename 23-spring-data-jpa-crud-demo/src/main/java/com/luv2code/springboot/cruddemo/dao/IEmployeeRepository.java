package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;


/*
 * Podsetnik za Spring Data JPA:
 * 
 * Spring Data JPA ima vec predefinisane metode ( findAll, findById, save/merge, delete) i tehnicki za ovakve situacije nije potrebno da se pise bilo kakav DAO kod
 * 
 * Bice dovoljno samo proslediti objekat/ entity type i key/PK , takodje JpaRepository provajduje @Transactinal tako da se to moze skloniti iz metoda unutar Service
 * 
 */

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// to je to, ne mora nista vise da se pise, samo obrati paznju da je sve podeseno kako treba u Service-u :)

}
