/**
 * @author Karthik Selvaraj
 *
 * 
 */
package com.demo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.api.models.Address;

//for jpa repository method reference : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

public interface AddressRepository extends JpaRepository<Address, Integer> {

}