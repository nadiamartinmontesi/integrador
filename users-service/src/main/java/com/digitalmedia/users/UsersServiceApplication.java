package com.digitalmedia.users;

import com.digitalmedia.users.model.User;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class UsersServiceApplication {

  public static void save(User user, String group){
    Keycloak keycloak = KeycloakBuilder
            .builder()
            .serverUrl("http://localhost:8082/")
            .realm("DigitalMedia")
            .clientId("microservicios")
            .clientSecret("3DZCKkEXAyoYvXEbeQcdeP32SA1EBgKN")
            .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
            .build();


    CredentialRepresentation credentialRepresentationAdmin = new CredentialRepresentation();
    credentialRepresentationAdmin.setType(CredentialRepresentation.PASSWORD);
    credentialRepresentationAdmin.setValue(group);
    UserRepresentation userRepresentationAdmin = new UserRepresentation();
    userRepresentationAdmin.setUsername(user.getUsername());
    userRepresentationAdmin.setFirstName(user.getFirstName());
    userRepresentationAdmin.setLastName(user.getLastName());
    userRepresentationAdmin.setEnabled(true);
    userRepresentationAdmin.setGroups(List.of(group));
    userRepresentationAdmin.setEmail(user.getEmail());
    userRepresentationAdmin.setCredentials(Arrays.asList(credentialRepresentationAdmin));
    keycloak.realm("DigitalMedia").users().create(userRepresentationAdmin);
  }

  public static void main(String[] args) {
    SpringApplication.run(UsersServiceApplication.class, args);

    User userAdmin = new User("useradmin", "admin@mail", "adminName", "adminLastName");
    User userClient = new User("userclient", "client@mail", "clientName", "clientLastName");
    User userProvider = new User("userprovider", "provider@mail", "providerName", "providerLastName");

    save(userAdmin, "admin");
    save(userClient, "client");
    save(userProvider, "provider");
    
  }

}
