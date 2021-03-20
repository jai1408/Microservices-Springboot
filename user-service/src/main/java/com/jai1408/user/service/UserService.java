package com.jai1408.user.service;

import com.jai1408.user.VO.Department;
import com.jai1408.user.VO.ResponseTemplateVO;
import com.jai1408.user.entity.User;
import com.jai1408.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

  @Autowired private UserRepository userRepository;
  @Autowired private RestTemplate restTemplate;

  public User saveUser(User user) {
    log.info("inside saveUser() of UserService");
    return userRepository.save(user);
  }

  public ResponseTemplateVO getUserWithDept(Long userId) {
    ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
    Optional<User> optionalUser = userRepository.findById(userId);
    User user = new User();
    if (optionalUser.isPresent()) user = optionalUser.get();
    Department department =
        restTemplate.getForObject(
            "http://127.0.0.1:9001/departments/" + user.getDepartmentId(), Department.class);
    responseTemplateVO.setUser(user);
    responseTemplateVO.setDepartment(department);
    return responseTemplateVO;
  }
}
