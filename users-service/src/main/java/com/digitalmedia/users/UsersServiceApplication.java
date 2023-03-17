package com.digitalmedia.users;

import com.digitalmedia.users.configuration.KeycloakConfiguration;
import com.digitalmedia.users.model.User;
import com.digitalmedia.users.repository.KeycloakRepository;
import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UsersServiceApplication.class, args);
    //User userAdmin = new User("userAdmin", "admin@mail.com", "Admin", "Admin");

    //KeycloakConfiguration keycloakConfiguration = new KeycloakConfiguration();
    //keycloakConfiguration.buildClient();

    //KeycloakRepository keycloakRepository = new KeycloakRepository();
    //keycloakRepository.save(userAdmin, "admin");
  }

}
