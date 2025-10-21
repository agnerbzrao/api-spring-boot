package api.spring.java.repository;

import aj.org.objectweb.asm.commons.Remapper;
import api.spring.java.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Page<UserEntity> findAllByActivedTrue(Pageable pagination);
}
