package api.spring.java.controller;

import api.spring.java.entity.UserEntity;
import api.spring.java.repository.UserRepository;
import api.spring.java.user.ListUserData;
import api.spring.java.user.UserDataRecord;
import api.spring.java.user.UserDataUpdate;
import api.spring.java.user.UserUpdated;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<List<UserUpdated>> insertUserData(
            @RequestBody @Valid List<UserDataRecord> userData) {

        List<UserUpdated> createdUsers = userData.stream()
                .map(UserEntity::new)
                .map(userRepository::save)
                .map(UserUpdated::new)
                .toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsers);
    }


    @GetMapping
    public ResponseEntity<Page<ListUserData>> listUsers(
            @PageableDefault(size=10, sort={"firstName"})
            Pageable pagination
    ) {
        Page<ListUserData> listuserResponse =  userRepository
                .findAllByActivedTrue(pagination)
                .map(ListUserData::new);

        return ResponseEntity.ok(listuserResponse);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateUser(@RequestBody @Valid UserDataUpdate userData){
        UserEntity userEntity = userRepository.getReferenceById(userData.id());
        userEntity.updateUserEntity(userData);
        return ResponseEntity.ok(new UserUpdated(userEntity));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id){
        UserEntity userEntity = userRepository.getReferenceById(id);
        userEntity.deleteUserId();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity getUserById(@PathVariable Long id){
        UserEntity userEntity = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new UserUpdated(userEntity));
    }
}
