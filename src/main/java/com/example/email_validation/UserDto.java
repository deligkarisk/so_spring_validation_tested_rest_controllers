package com.example.email_validation;

import javax.validation.constraints.*;

public class UserDto {

    @Size
        @NotNull
        @Size(min=2, max= 6)
        private String name;

        @NotNull
        @Size(min=4, max= 50)
        private String password;

        @Email
        private String email;

        public UserDto(String name, String password, String email) {
            super();
            this.name = name;
            this.password = password;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

