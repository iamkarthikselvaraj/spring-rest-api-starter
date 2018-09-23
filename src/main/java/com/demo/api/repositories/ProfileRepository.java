/**
 * @author Karthik Selvaraj
 *
 * 
 */
package com.demo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.api.models.Profile;

//for jpa repository method reference : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	List<Profile> findAllByFirstname(String firstname);
}