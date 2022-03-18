package spring.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.interfaceService.IReserveService;
import spring.model.Reserve;
import spring.repository.ReserveRepository;

@Service
public class ReserveService implements IReserveService {

	@Autowired
	private ReserveRepository reserveRepo; // inyectamos

	@Override
	@Transactional(readOnly = true)
	public Iterable<Reserve> findAll() {
		return reserveRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Reserve> findAll(Pageable pageable) {
		return reserveRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Reserve> findById(Long id) {
		return reserveRepo.findById(id);
	}

	@Override
	@Transactional
	public Reserve save(Reserve r) {
		return reserveRepo.save(r);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		reserveRepo.deleteById(id);
	}

	@Override
	@Transactional
	public Reserve update(Reserve rRequest, Long id) {
		Optional<Reserve> reserva = reserveRepo.findById(id);

		reserva.get().setPostalCode(rRequest.getPostalCode());
		reserva.get().setDescription(rRequest.getDescription());
		reserva.get().setDirection(rRequest.getDirection());
		reserva.get().setState(rRequest.getState());
		reserva.get().setDate(rRequest.getDate());
		reserva.get().setPayment(rRequest.getPayment());
		reserva.get().setEnable(rRequest.isEnable());
		reserva.get().setCoords(rRequest.getCoords());
		reserva.get().setMail(rRequest.getMail());
		reserva.get().setName(rRequest.getName());
		reserva.get().setPrivateOrPublic(rRequest.getPrivateOrPublic());
		reserva.get().setProvince(rRequest.getProvince());
		reserva.get().setPhone(rRequest.getPhone());
		reserva.get().setTypeEvent(rRequest.getTypeEvent());
		reserva.get().setUser(rRequest.getUser());
		
		return reserveRepo.save(reserva.get());
	}

}
