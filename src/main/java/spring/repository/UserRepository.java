package spring.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.model.User;




@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	@Query(value="select u from User u where u.username = ?1 and u.password = ?2")
	List<User> findByUserAndPassword(String username, String password);
	
	Optional<User>findByUsername(String user);

	




	
	

}
