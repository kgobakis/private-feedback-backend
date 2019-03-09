package com.example.kostas.demoeeee.repository;

import com.example.kostas.demoeeee.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {}