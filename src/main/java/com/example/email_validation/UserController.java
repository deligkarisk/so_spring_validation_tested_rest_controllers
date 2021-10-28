package com.example.email_validation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {


        @PostMapping
        public ResponseEntity<String> createUser(@ModelAttribute @Valid @RequestBody UserDto userDto,
                                                 Errors errors){

          if (errors.hasErrors()) {
              return ResponseEntity.badRequest().body("Errors exist");
            }
            return ResponseEntity.ok("Success");
        }
    }

