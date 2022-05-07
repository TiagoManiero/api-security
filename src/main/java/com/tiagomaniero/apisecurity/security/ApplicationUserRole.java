package com.tiagomaniero.apisecurity.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.tiagomaniero.apisecurity.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ESTUDANTE(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(CURSO_READ, CURSO_WRITE, ESTUDANTE_READ, ESTUDANTE_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(CURSO_READ, ESTUDANTE_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}
