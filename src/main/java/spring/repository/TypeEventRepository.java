package spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.TypeEvent;

@Repository
public interface TypeEventRepository extends JpaRepository<TypeEvent, Long> {


}
