package spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {

	

}
