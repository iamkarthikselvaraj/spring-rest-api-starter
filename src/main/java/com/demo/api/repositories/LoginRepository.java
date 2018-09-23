/**
 * @author Karthik Selvaraj
 *
 * 
 */
package com.demo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.api.models.Login;

//for jpa repository method reference : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

public interface LoginRepository extends JpaRepository<Login, Integer> {

	Login findByUsername(String username);
}