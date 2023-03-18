package com.digitalmedia.users.repository;


import com.digitalmedia.users.model.User;
import com.digitalmedia.users.model.dto.UserDTO;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class KeycloakRepository {

    @Autowired
    private Keycloak keycloak;
    @Value("${dm.keycloak.realm}")
    private String realm;

    public List<UserDTO> findNoAdmin(){

        List<GroupRepresentation> groupRepresentations = keycloak
                .realm(realm)
                .groups()
                .groups();

        List<UserRepresentation> allUserRepresentations = new ArrayList<>();
        List<UserRepresentation> adminUserRepresentations = new ArrayList<>();

        allUserRepresentations=keycloak
                .realm(realm)
                .users()
                .list();

        for(GroupRepresentation g: groupRepresentations) {
            if (g.getName().contains("admin"))
            {adminUserRepresentations=keycloak.realm(realm)
                    .groups()
                    .group(g.getId())
                    .members();
                break;
            }
        }

        List<UserRepresentation> finalUser = allUserRepresentations;

        for(int f=0; f<allUserRepresentations.size();f++)
            for(int i=0;i<adminUserRepresentations.size();i++)
                if(allUserRepresentations.get(f).getId().contains(adminUserRepresentations.get(i).getId()))
                    finalUser.remove(f);


        List<UserDTO> userDTOList = finalUser.stream().map(this::toUserDTO).collect(Collectors.toList());

        return userDTOList;
    }

    private UserDTO toUserDTO(UserRepresentation userRepresentation) {
        return new UserDTO(userRepresentation.getUsername(), userRepresentation.getEmail());
    }

    public User save(User user, String group) {
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();

        UserRepresentation userRepresentation = toUserRepresentation(user);
        userRepresentation.setGroups(List.of(group));

        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(group);

        Response response = keycloak.realm(realm).users().create(userRepresentation);
        //if (response.getStatus() == 200) {
        //    List<UserRepresentation> users = keycloak.realm(realm).users().search(user.getUsername());
        //    return toUserModel(users.get(0));
        //}
        return null;
    }

    private UserRepresentation toUserRepresentation(User user) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(user.getUsername());
        userRepresentation.setFirstName(user.getFirstName());
        userRepresentation.setLastName(user.getLastName());
        userRepresentation.setEmail(user.getEmail());

        //userRepresentation.setRequiredActions(List.of("UPDATE_PASSWORD"));

        return userRepresentation;
    }

    private User toUserModel(UserRepresentation userRepresentation) {
        return new User(userRepresentation.getUsername(), userRepresentation.getEmail(), userRepresentation.getFirstName(), userRepresentation.getLastName());
    }

    public User findByUsername(String username){
        List <UserRepresentation> user = keycloak
                .realm(realm)
                .users()
                .search(username);

        return toUserModel(user.get(0));
    }
}
