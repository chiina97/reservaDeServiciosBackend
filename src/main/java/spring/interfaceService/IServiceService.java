package spring.interfaceService;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import spring.model.Services;



public interface IServiceService {
	public Iterable<Services> findAll();

	public Page<Services> findAll(Pageable pageable);

	public Optional<Services> findById(Long id);

	public Services save(Services s);
	
	public Services update(Services s,Long id);

	public void deleteById(Long id);

}
