package com.springrest.repository;



import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springrest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
		
	User findByUsername(String username);
	
	@Query("select u from User u where u.username like %?1%")
	Page<User> findByUserName(String keyword,Pageable pegeable);
	
	

	

}
