package com.digitalmedia.users.service;

import com.digitalmedia.users.model.User;
import com.digitalmedia.users.model.dto.UserDTO;
import com.digitalmedia.users.repository.KeycloakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private KeycloakRepository keycloakRepository;

  public List<UserDTO> findNoAdmin(){
    return keycloakRepository.findNoAdmin();
  }

  public User findByUsername(String username){
    return keycloakRepository.findByUsername(username);
  }
}
