/**
 * 
 */
package com.johnwu.bookstorebackend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.johnwu.bookstorebackend.domain.security.User;

/**
 * @author Zhou
 *
 */

/*CurdRepository will help us generate the crete class for UserRepository. 
 * it has two parameters, one is the class record that we want to get from database, 
 * and another one is the class' primary key*/

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
}
