package com.pfa.privatefeedbackapp.service;

import com.pfa.privatefeedbackapp.entities.Role;
import com.pfa.privatefeedbackapp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<Role>();
        roleRepository.findAll().forEach(role -> roles.add(role));
        return roles;
    }

    //    public User getUserById(int id) {
//        return userRepository.findById(id).get();
//    }
//
    public void saveOrUpdate(Role role) {
        roleRepository.save(role);
    }
//
//    public void delete(int id) {
//        userRepository.deleteById(id);
//    }
}
