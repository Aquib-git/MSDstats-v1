package com.kng.medicalreports.utils;

import org.springframework.stereotype.Component;
import java.util.Collection;

@Component
public class ThymeleafUtils {

    public boolean containsAny(Collection<String> userRoles, Collection<String> requiredRoles) {
        for (String role : requiredRoles) {
            if (userRoles.contains(role)) {
                return true;
            }
        }
        return false;
    }
}
