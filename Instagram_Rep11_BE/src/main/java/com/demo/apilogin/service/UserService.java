package com.demo.apilogin.service;

import com.demo.apilogin.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final String EXISING_EMAIL = "test@gmail.com";

    private static final String EXISING_EMAIL2 = "test2@gmail.com";


    public Optional<UserEntity>findByEmail(String email) {

        if(EXISING_EMAIL.equalsIgnoreCase(email)){

            var user = new UserEntity();
            user.setId(1L);
            user.setEmail(EXISING_EMAIL);
            user.setPassword("$2a$12$nSJp0Pk418KTlsrDPUHS8uy8bxgYb0cMi3kRuh3NiIbVkQFqIIRcW"); //test
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("ADMIN");

            return Optional.of(user);
        } else if (EXISING_EMAIL2.equalsIgnoreCase(email)) {

            var user = new UserEntity();
            user.setId(100L);
            user.setEmail(EXISING_EMAIL2);
            user.setPassword("$2a$12$nSJp0Pk418KTlsrDPUHS8uy8bxgYb0cMi3kRuh3NiIbVkQFqIIRcW"); //test
            user.setRole("ROLE_USER");
            user.setExtraInfo("User");
            return Optional.of(user);

        }

        return Optional.empty();

    }

}
