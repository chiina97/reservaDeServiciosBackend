package spring.interfaceService;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import spring.model.Image;

public interface IImagService {

	public Iterable<Image> findAll();

	public Page<Image> findAll(Pageable pageable);

	public Optional<Image> findById(Long id);

	public Image save(Image i);

	public Image update(Image i, Long id);

	public void deleteById(Long id);

}
