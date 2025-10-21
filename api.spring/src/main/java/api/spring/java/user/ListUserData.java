package api.spring.java.user;

import api.spring.java.entity.UserEntity;

public record ListUserData(Long id, String firstName, String email, Boolean actived) {
    public ListUserData(UserEntity userEntity){

        this(
            userEntity.getId(),
            userEntity.getFirstName(),
            userEntity.getEmail(),
            userEntity.getActived()
        );
    }
}
