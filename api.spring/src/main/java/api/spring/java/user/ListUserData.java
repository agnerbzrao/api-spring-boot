package api.spring.java.user;

import api.spring.java.entity.UserEntity;

public record ListUserData(String firstName, String email) {
    public ListUserData(UserEntity userEntity){
        this(userEntity.getFirstName(), userEntity.getEmail());
    }
}
