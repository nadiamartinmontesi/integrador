package com.digitalmedia.users.controller;

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

  //@GetMapping("/me")
  //public User getUserExtra(@RequestParam String principal) {
  //  return userService.validateAndGetUserExtra(principal);
  //}

  //@PostMapping("/me")
  //public User saveUserExtra(@Valid @RequestBody UserDTO updateUserRequest, @RequestParam(value = "principal") String principal) {
  //  Optional<User> userOptional = userService.getUserExtra(principal);
  //  User userExtra = userOptional.orElseGet(() -> new User(principal));
  //  userExtra.setAvatar(updateUserRequest.getAvatar());
  //  return userService.saveUserExtra(userExtra);
  //}
}
