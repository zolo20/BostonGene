package userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.entity.UserEntity;
import userservice.form.UserForm;
import userservice.service.UserService;
import userservice.utils.Converter;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> postAdd(@RequestBody UserForm userForm) {
        UserEntity user = userService.saveUser(userForm);
        if (user != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserForm getUserByEmail(@RequestParam("email") String email, HttpServletResponse response) {
        UserEntity userEntity = userService.getUserByEmail(email);
        if (userEntity == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        UserForm userForm = new UserForm();
        userForm.setUserID(userEntity.getUserID());
        userForm.setEmail(userEntity.getEmail());
        userForm.setName(userEntity.getName());
        userForm.setPassword(userEntity.getPassword());
        userForm.setSurname(userEntity.getSurname());
        userForm.setBirthday(Converter.convertMillsToString(userEntity.getBirthday()));
        return userForm;
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        UserEntity userEntity = userService.deleteUser(id);
        if (userEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
