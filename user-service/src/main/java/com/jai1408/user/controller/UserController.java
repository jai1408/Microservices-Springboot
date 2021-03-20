package com.jai1408.user.controller;

import com.jai1408.user.VO.ResponseTemplateVO;
import com.jai1408.user.entity.User;
import com.jai1408.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  @Autowired private UserService userService;

  @PostMapping("/")
  public User saveUser(@RequestBody User user) {
    log.info("inside saveUser() of UserController");
    return userService.saveUser(user);
  }

  @GetMapping("/{userId}")
  public ResponseTemplateVO getUserWithDept(@PathVariable Long userId) {
    log.info("inside saveUser() of UserController");
    return userService.getUserWithDept(userId);
  }
}
