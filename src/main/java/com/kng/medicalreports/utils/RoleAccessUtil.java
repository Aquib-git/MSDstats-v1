package com.kng.medicalreports.utils;

import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class RoleAccessUtil {

    public List<String> getAllAccessRoles() {
        return Arrays.asList("ROLE_ADMIN");
    }

    public List<String> getGeneralAccessRoles() {
        return Arrays.asList("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_NUSER");
    }

    public List<String> getLabAccessRoles() {
        return Arrays.asList("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_LAB");
    }

    public List<String> getManagerAccessRoles() {
        return Arrays.asList("ROLE_ADMIN", "ROLE_MANAGER");
    }
}
