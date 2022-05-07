package com.tiagomaniero.apisecurity.auth;

import com.google.common.collect.Lists;
import com.tiagomaniero.apisecurity.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return retornarApplicationUsers().stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> retornarApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
            new ApplicationUser(
                    "tiago",
                    passwordEncoder.encode("password"),
                    ApplicationUserRole.ESTUDANTE.getGrantedAuthority(),
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                    "linda",
                    passwordEncoder.encode("password123"),
                    ApplicationUserRole.ADMIN.getGrantedAuthority(),
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                    "tom",
                    passwordEncoder.encode("password123"),
                    ApplicationUserRole.ADMINTRAINEE.getGrantedAuthority(),
                    true,
                    true,
                    true,
                    true
            )
        );

        return applicationUsers;
    }
}
