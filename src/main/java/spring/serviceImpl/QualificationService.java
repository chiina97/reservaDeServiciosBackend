package spring.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.interfaceService.IQualificationService;
import spring.model.Qualification;
import spring.repository.QualificationRepository;

@Service
public class QualificationService implements IQualificationService{
	 
		@Autowired
		private QualificationRepository qualificationRepo; //inyectamos

		
		@Override
		@Transactional(readOnly = true)
		public Iterable<Qualification> findAll() {
			return qualificationRepo.findAll();
		}

		@Override
		@Transactional(readOnly = true)
		public Page<Qualification> findAll(Pageable pageable) {
			return qualificationRepo.findAll(pageable);
		}

		@Override
		@Transactional(readOnly = true)
		public Optional<Qualification> findById(Long id) {
			return qualificationRepo.findById(id);
		}

		@Override
		@Transactional
		public Qualification save(Qualification c) {
			return qualificationRepo.save(c);
		}

		@Override
		@Transactional
		public void deleteById(Long id) {
			qualificationRepo.deleteById(id);
		}

	

		@Override
		@Transactional
		public Qualification update(Qualification cRequest, Long id) {
			Optional<Qualification> qualification = qualificationRepo.findById(id);
			
			qualification.get().setPriceQuality(cRequest.getPriceQuality());
			qualification.get().setDesign(cRequest.getDesign());
			qualification.get().setEnable(cRequest.isEnable());
			qualification.get().setCleaning(cRequest.getCleaning());
			qualification.get().setTaste(cRequest.getTaste());
			qualification.get().setSympathy(cRequest.getSympathy());
			qualification.get().setService(cRequest.getService());
			qualification.get().setUser(cRequest.getUser());
			
			return qualificationRepo.save(qualification.get());
		}

		
		

	}
