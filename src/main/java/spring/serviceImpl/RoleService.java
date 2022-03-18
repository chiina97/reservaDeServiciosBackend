package spring.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.enums.RoleName;
import spring.model.Role;
import spring.repository.RoleRepository;


@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Optional<Role> getByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Transactional
    public void save(Role rol) {
        roleRepository.save(rol);
    }

    @Transactional(readOnly = true)
    public ArrayList<Role> findAll() {
        return (ArrayList<Role>) roleRepository.findAll();
    }
}
