/**
 * @author Karthik Selvaraj
 *
 * 
 */
package com.demo.api.repositories.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.demo.api.repositories.custom.ProfileRepositoryCustom;

@Service
public class ProfileRepositoryCustomImpl implements ProfileRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

}