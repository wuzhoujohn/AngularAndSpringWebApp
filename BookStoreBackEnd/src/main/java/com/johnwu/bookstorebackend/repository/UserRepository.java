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

/*in order to user CrudRespository, you have to include spring-data-commons inside your pom.xml file
 * or it wont work, since the version of spring boot for this web app is 1.5.2, so the corresponding spring-data-commons
 * is 1.13.1.release*/

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
}
