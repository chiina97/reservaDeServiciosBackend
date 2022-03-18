package spring.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.interfaceService.ITypeEventService;
import spring.model.TypeEvent;
import spring.repository.TypeEventRepository;

@Service
public class TypeEventService implements ITypeEventService {

	@Autowired
	private TypeEventRepository typeEventRepo; // inyectamos

	@Override
	@Transactional(readOnly = true)
	public Iterable<TypeEvent> findAll() {
		return typeEventRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TypeEvent> findAll(Pageable pageable) {
		return typeEventRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TypeEvent> findById(Long id) {
		return typeEventRepo.findById(id);
	}

	@Override
	@Transactional
	public TypeEvent update(TypeEvent teRequest, Long id) {
		Optional<TypeEvent> te = typeEventRepo.findById(id);

		te.get().setType(teRequest.getType());
		te.get().setEnable(teRequest.isEnable());
		return typeEventRepo.save(te.get());
	}

	@Override
	@Transactional
	public TypeEvent save(TypeEvent te) {
		return typeEventRepo.save(te);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		typeEventRepo.deleteById(id);
	}

}
