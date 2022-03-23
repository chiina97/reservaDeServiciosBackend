package spring.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.interfaceService.IServiceService;
import spring.model.Services;
import spring.repository.ServiceRepository;

@Service
public class ServiceService implements IServiceService {

	@Autowired
	private ServiceRepository serviceRepo; // inyectamos

	@Override
	@Transactional(readOnly = true)
	public Iterable<Services> findAll() {
		return serviceRepo.findAllServices();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Services> findAll(Pageable pageable) {
		return serviceRepo.findAll(pageable);
	}
	
	@Transactional(readOnly=true)
	public Iterable<Services> findAllServicesByType(Long id ) {
		return serviceRepo.findAllServicesByTypeService(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Services> findById(Long id) {
		return serviceRepo.findById(id);
	}

	@Override
	@Transactional
	public Services save(Services s) {
		return serviceRepo.save(s);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		serviceRepo.deleteById(id);
		
	}

	@Override
	public Services update(Services sRequest, Long id) {
		Optional<Services> service = serviceRepo.findById(id);
		if (service.isPresent()) {
		service.get().setDescription(sRequest.getDescription());
		service.get().setEnable(sRequest.isEnable());
		service.get().setInstagram(sRequest.getInstagram());
		service.get().setName(sRequest.getName());
		service.get().setTypeService(sRequest.getTypeService());
		service.get().setTwitter(sRequest.getTwitter());
		service.get().setUrlWeb(sRequest.getUrlWeb());
		service.get().setWsp(sRequest.getWsp());
		
		return serviceRepo.save(service.get());
		}
		else
			return null;
	}
	@Transactional(readOnly = true)
	public List<Services> findAllByIdUser(Long id) {
		return serviceRepo.findAllByIdUser(id);
	}

}
