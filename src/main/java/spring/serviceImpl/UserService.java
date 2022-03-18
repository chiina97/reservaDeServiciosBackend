package spring.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.interfaceService.IUserService;
import spring.model.User;
import spring.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository usuarioRepo; // inyectamos

	@Override
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		return usuarioRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		return usuarioRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return usuarioRepo.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<User> findByUsername(String username) {
		return usuarioRepo.findByUsername(username);
	}

	@Override
	@Transactional
	public User save(User user) {
		return usuarioRepo.save(user);
	}

	@Override
	@Transactional
	public User update(User userRequest, Long id) {
		Optional<User> user = usuarioRepo.findById(id);
		if (user.isPresent()) {
			user.get().setName(userRequest.getName());
			user.get().setSurname(userRequest.getSurname());
			user.get().setUsername(userRequest.getUsername());
			user.get().setMail(userRequest.getMail());
			return usuarioRepo.save(user.get());
		} else
			return null;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		usuarioRepo.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<User> findByUserAndPassword(String usuario, String clave) {
		return usuarioRepo.findByUserAndPassword(usuario, clave);
	}
	


}
