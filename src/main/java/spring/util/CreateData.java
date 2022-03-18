package spring.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spring.enums.RoleName;
import spring.model.Role;
import spring.model.TypeService;
import spring.serviceImpl.RoleService;
import spring.serviceImpl.TypeServiceService;


@Component
public class CreateData implements CommandLineRunner {

	  @Autowired
	  RoleService roleService;
	  
	  @Autowired
	  TypeServiceService typeService;
	  

	@Override
	public void run(String... args) throws Exception {
		
		
		if (roleService.findAll().isEmpty()) {
		      Role roleUser = new Role(RoleName.ROLE_USER);
		      roleService.save(roleUser);
		    }
		
		
	    String servicesType = "show en vivo,Food truck,Catering,Wedding planner,Filmación y fotos";
	    ArrayList<TypeService> listS = (ArrayList<TypeService>) typeService.findAll();
	    if (listS.isEmpty()) {
	      String[] list = servicesType.split((","));
	      for (String elem : list) {
	        typeService.save(new TypeService(elem));
	      }
	    }
		
	}
	 
}
