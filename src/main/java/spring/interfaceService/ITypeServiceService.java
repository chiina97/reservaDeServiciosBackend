package spring.interfaceService;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import spring.model.TypeService;



public interface ITypeServiceService {
	public Iterable<TypeService> findAll();

	public Page<TypeService> findAll(Pageable pageable);

	public Optional<TypeService> findById(Long id);

	public TypeService save(TypeService te);
	
	public TypeService update(TypeService ts,Long id);

	public void deleteById(Long id);

}
