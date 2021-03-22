package com.jai1408.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

  @GetMapping("/userServiceFallBack")
  public String userServiceFallback() {
    return "User Service is taking longer than expected. Please try again later.";
  }

  @GetMapping("/deptServiceFallBack")
  public String deptServiceFallback() {
    return "Department Service is taking longer than expected. Please try again later.";
  }
}
