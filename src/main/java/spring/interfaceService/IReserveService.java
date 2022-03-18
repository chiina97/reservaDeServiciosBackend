package spring.interfaceService;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import spring.model.Reserve;


public interface IReserveService {
public Iterable<Reserve> findAll();
	
	public Page<Reserve> findAll(Pageable pageable);
	
	public Optional<Reserve> findById(Long id);
	
	public Reserve save(Reserve r);
	
	public Reserve update(Reserve r,Long id);
	
	public void deleteById(Long id);

}
