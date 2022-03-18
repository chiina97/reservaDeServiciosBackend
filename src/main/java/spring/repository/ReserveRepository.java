package spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {


}
