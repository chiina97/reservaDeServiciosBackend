package spring.controller;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import spring.dto.TypeServiceDTO;
import spring.model.TypeService;
import spring.serviceImpl.TypeServiceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/typeService", produces = MediaType.APPLICATION_JSON_VALUE)
public class TypeServiceController {
	@Autowired
	private TypeServiceService typeServiceService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<TypeServiceDTO> create(@RequestBody TypeServiceDTO typeServiceDTO){
		
		// convert DTO to entity
		TypeService typeServiceRequest = modelMapper.map(typeServiceDTO, TypeService.class);
		
		TypeService typeService = typeServiceService.save(typeServiceRequest);
		
		// convert entity to DTO
		TypeServiceDTO typeServiceResponse = modelMapper.map(typeService, TypeServiceDTO.class);
		
		
		return new ResponseEntity<TypeServiceDTO>(typeServiceResponse,HttpStatus.CREATED);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TypeServiceDTO> getTypeServiceById(@PathVariable(value = "id") Long typeServiceId) {
		Optional<TypeService> typeService = typeServiceService.findById(typeServiceId);

		// convert entity to DTO
		
		if (typeService.isPresent()){
			TypeServiceDTO typeServiceResponse = modelMapper.map(typeService.get(), TypeServiceDTO.class);
            return ResponseEntity.ok(typeServiceResponse);
        }
		else {
			return ResponseEntity.notFound().build();
        }
	}
	
	@GetMapping("/list")
	public ResponseEntity<Iterable<TypeService>> getTypeService() {
		return ResponseEntity.ok(typeServiceService.findAll());
	}
	
	

}
