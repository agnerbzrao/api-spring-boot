package api.spring.java.user;

import api.spring.java.entity.UserEntity;

public record UserUpdated(Long id, String nome, String email, Boolean actived) {
    public UserUpdated(UserEntity userEntity){
        this(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getEmail(),
                userEntity.getActived()
        );
    }
}
