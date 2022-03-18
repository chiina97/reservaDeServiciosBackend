package spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.Image;

@Repository
public interface ImagRepository extends JpaRepository<Image, Long> {


}