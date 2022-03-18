package spring.serviceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.interfaceService.IImagService;
import spring.model.Image;
import spring.repository.ImagRepository;

@Service
public class ImagenService implements IImagService{
	 
		@Autowired
		private ImagRepository imagenRepo; //inyectamos


		@Override
		@Transactional(readOnly = true)
		public Iterable<Image> findAll() {
			return imagenRepo.findAll();
		}

		@Override
		@Transactional(readOnly = true)
		public Page<Image> findAll(Pageable pageable) {
			return imagenRepo.findAll(pageable);
		}

		@Override
		@Transactional(readOnly = true)
		public Optional<Image> findById(Long id) {
			return imagenRepo.findById(id);
		}

		@Override
		@Transactional
		public Image save(Image i) {
			return imagenRepo.save(i);
		}

		@Override
		@Transactional
		public void deleteById(Long id) {
			imagenRepo.deleteById(id);
		}


		@Override
		@Transactional
		public Image update(Image iRequest, Long id) {
			Optional<Image> imagen = imagenRepo.findById(id);
			
			imagen.get().setImag(iRequest.getImag());
			return imagenRepo.save(imagen.get());
			
		}

		
		
	}
