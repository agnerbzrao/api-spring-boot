package api.spring.java.controller;

import api.spring.java.entity.UserEntity;
import api.spring.java.repository.UserRepository;
import api.spring.java.user.ListUserData;
import api.spring.java.user.UserDataRecord;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public void insertUserData(@RequestBody @Valid UserDataRecord userData)
    {
        userRepository.save(new UserEntity(userData));
    }

    @GetMapping
    public Page<ListUserData> listUsers(
            @PageableDefault(size=10, sort={"firstName"})
            Pageable pagination
    ) {
       return userRepository.findAll(pagination).map(ListUserData::new);
    }
}
