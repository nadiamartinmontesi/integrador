package com.digitalmedia.users.controller;

import com.digitalmedia.users.model.User;
import com.digitalmedia.users.model.dto.UserDTO;
import com.digitalmedia.users.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/admin")
  @PreAuthorize("hasAuthority('GROUP_admin')")
  public List<UserDTO> getUsersNoAdmin() {
    return userService.findNoAdmin();
  }

  @GetMapping("/admin/find/{username}")
  @PreAuthorize("hasAuthority('GROUP_admin')")
  public User getUserByUsernameAdmin(@PathVariable("username") String username) {
    return userService.findByUsername(username);
  }

  @GetMapping("/find/{username}")
  public User getUserByUsername(@PathVariable("username") String username) {
    return userService.findByUsername(username);
  }
}
