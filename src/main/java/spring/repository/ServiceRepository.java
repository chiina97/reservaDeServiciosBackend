package spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.model.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {

	@Query(value="SELECT s FROM Services s WHERE s.user.id =?1 and s.enable=true")
	List<Services> findAllByIdUser(Long id);
	
	@Query(value="SELECT s FROM Services s WHERE s.enable=true")
	List<Services> findAllServices();
	

}
