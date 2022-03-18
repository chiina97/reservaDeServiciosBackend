package spring.interfaceService;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import spring.model.TypeEvent;

public interface ITypeEventService {
	public Iterable<TypeEvent> findAll();

	public Page<TypeEvent> findAll(Pageable pageable);

	public Optional<TypeEvent> findById(Long id);

	public TypeEvent save(TypeEvent te);
	
	public TypeEvent update(TypeEvent te,Long id);
	
	public void deleteById(Long id);

}
