package spring.interfaceService;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import spring.model.Qualification;

public interface IQualificationService {

	public Iterable<Qualification> findAll();

	public Page<Qualification> findAll(Pageable pageable);

	public Optional<Qualification> findById(Long id);

	public Qualification save(Qualification c);
	
	public Qualification update(Qualification c,Long id);

	public void deleteById(Long id);
}
