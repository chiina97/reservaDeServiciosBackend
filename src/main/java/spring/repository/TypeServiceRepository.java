package spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.TypeService;



@Repository
public interface TypeServiceRepository extends JpaRepository<TypeService, Long>{


}
