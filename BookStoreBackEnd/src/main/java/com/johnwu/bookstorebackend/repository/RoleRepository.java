package com.johnwu.bookstorebackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.johnwu.bookstorebackend.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	/*here are some default methods that will be automatically implemented by 
	 * spring, like save, findAll etc.*/
}
