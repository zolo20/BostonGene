package userservice.repository;

import org.springframework.data.repository.CrudRepository;
import userservice.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity getUserEntityByEmail(String email);
    UserEntity getUserEntityByUserID(long id);
}
