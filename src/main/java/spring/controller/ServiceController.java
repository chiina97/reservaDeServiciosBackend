package spring.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import spring.dto.Message;
import spring.dto.ServiceDTO;
import spring.model.Services;
import spring.model.TypeService;
import spring.model.User;
import spring.serviceImpl.ServiceService;
import spring.serviceImpl.TypeServiceService;
import spring.serviceImpl.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/service", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceController {

	@Autowired
	private ServiceService serviceService;
	
	@Autowired
	private TypeServiceService tiposerviceService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	// Create a new service
	@PostMapping
	public ResponseEntity<?> create(@Valid@RequestBody ServiceDTO servicioDTO,BindingResult result) {
		// validaciones:
		if (result.hasErrors()) {
			return new ResponseEntity<Message>(new Message(result.getFieldError().getDefaultMessage()),
							HttpStatus.BAD_REQUEST);
				}
		// convert DTO to entity
		
		Services serviceRequest = modelMapper.map(servicioDTO, Services.class);
		
		Optional<TypeService> idServicio=tiposerviceService.findById(Long.valueOf(servicioDTO.getTypeServiceId()));
		serviceRequest.setTypeService(idServicio.get());			
		
		Optional<User> idUsuario=userService.findById(servicioDTO.getUserId());
        serviceRequest.setUser(idUsuario.get());
        
        serviceRequest.setEnable(true);
        
		Services service = serviceService.save(serviceRequest);

		// convert entity to DTO
		ServiceDTO serviceResponse = modelMapper.map(service, ServiceDTO.class);

		return new ResponseEntity<ServiceDTO>(serviceResponse, HttpStatus.CREATED);
	}

	// Update an servicio
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid@RequestBody ServiceDTO serviceDTO,BindingResult result,
			@PathVariable(value = "id") Long serviceId) {
		
		// validaciones:
				if (result.hasErrors()) {
					return new ResponseEntity<Message>(new Message(result.getFieldError().getDefaultMessage()),
									HttpStatus.BAD_REQUEST);
						}
				
		// convert DTO to Entity
		Services serviceRequest = modelMapper.map(serviceDTO, Services.class);

		serviceService.update(serviceRequest, serviceId);

		return new ResponseEntity<Message>(new Message("Servicio actualizado!"),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<?> getServicioById(@PathVariable(value = "id") Long serviceId) {
		Optional<Services> service = serviceService.findById(serviceId);

		// convert entity to DTO
		//ServiceDTO serviceResponse = modelMapper.map(service.get(), ServiceDTO.class);
		if (service.isPresent()){
            return ResponseEntity.ok(service.get());
        }
		else {
			return ResponseEntity.notFound().build();
        }

	}
	
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long serviceId) {
		// convert DTO to Entity
		Optional<Services> service = serviceService.findById(serviceId);
		if(service.isPresent()) {
			serviceService.deleteById(serviceId);
			return new ResponseEntity<Message>(new Message("Servicio "+service.get().getName() +" eliminado!"), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Message>(new Message("El servicio no existe"), HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Iterable<Services>> getServiciosByUser(@PathVariable(value = "id") Long userId) {
		return ResponseEntity.ok(serviceService.findAllByIdUser(userId));

	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllServices() {
		
		return ResponseEntity.ok(serviceService.findAll());
		}
		
	

	@GetMapping("/list/{id}")
	public ResponseEntity<?> getAllServicesByType(@PathVariable(value = "id") Long typeId) {
	
		return ResponseEntity.ok(serviceService.findAllServicesByType(typeId));
	}
	
}
	


