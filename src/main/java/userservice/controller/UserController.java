package userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.entity.UserEntity;
import userservice.form.UserForm;
import userservice.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

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
        userForm.setBirthday(convert(userEntity.getBirthday()));
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

    private String convert(long birthday) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(birthday);

        int mYear = calendar.get(Calendar.YEAR);
        String mMonth = calendar.get(Calendar.MONTH) + 1 < 10 ? "0" + (calendar.get(Calendar.MONTH) + 1) : (calendar.get(Calendar.MONTH) + 1) + "";
        String mDay = calendar.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + calendar.get(Calendar.DAY_OF_MONTH) : calendar.get(Calendar.DAY_OF_MONTH) + "";
        return mDay + "." + mMonth + "." + mYear;
    }
}
