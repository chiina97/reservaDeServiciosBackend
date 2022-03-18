package spring.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.interfaceService.ITypeServiceService;
import spring.model.TypeService;
import spring.repository.TypeServiceRepository;

@Service
public class TypeServiceService implements ITypeServiceService {

	@Autowired
	private TypeServiceRepository typeServiceRepo; // inyectamos

	@Override
	@Transactional(readOnly = true)
	public Iterable<TypeService> findAll() {
		return typeServiceRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TypeService> findAll(Pageable pageable) {
		return typeServiceRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TypeService> findById(Long id) {
		return typeServiceRepo.findById(id);
	}

	@Override
	@Transactional
	public TypeService save(TypeService ts) {
		return typeServiceRepo.save(ts);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		typeServiceRepo.deleteById(id);
	}

	@Override
	public TypeService update(TypeService tsRequest, Long id) {
		Optional<TypeService> ts = typeServiceRepo.findById(id);

		ts.get().setType(tsRequest.getType());
		ts.get().setEnable(tsRequest.isEnable());
		return typeServiceRepo.save(ts.get());
	}

}
