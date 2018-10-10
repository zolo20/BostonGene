package userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import userservice.entity.UserEntity;
import userservice.form.UserForm;
import userservice.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity saveUser(UserForm userForm) {
        if (userRepository.getUserEntityByEmail(userForm.getEmail()) == null) {
            long checkDate = convertDateToMills(userForm.getBirthday());
            if (checkDate == -1) {
                return null;
            }

            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(userForm.getEmail());
            userEntity.setName(userForm.getName());
            userEntity.setSurname(userForm.getSurname());
            userEntity.setPassword(passwordEncoder.encode(userForm.getPassword()));
            userEntity.setBirthday(checkDate);

            userRepository.save(userEntity);
            return userEntity;
        } else {
            return null;
        }
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.getUserEntityByEmail(email);
    }

    public UserEntity deleteUser(long id) {
        UserEntity userEntity = userRepository.getUserEntityByUserID(id);
        if (userEntity == null) {
            return null;
        }
        userRepository.delete(userEntity);
        return userEntity;
    }

    private long convertDateToMills(String date) {
        try {
            date += "T00:00:00.000Z";
            LocalDateTime localDateTime = LocalDateTime.parse(date,
                    DateTimeFormatter.ofPattern("dd.MM.yyyy'T'HH:mm:ss.SSS'Z'"));

            return localDateTime
                    .atZone(ZoneId.systemDefault())
                    .toInstant().toEpochMilli();
        } catch (DateTimeParseException e) {
            return -1;
        }
    }
}
