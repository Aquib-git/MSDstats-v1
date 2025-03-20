package com.kng.medicalreports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.kng.medicalreports.utils.RoleAccessUtil;

public class RoleBaseController {

    @Autowired
    private RoleAccessUtil roleAccessUtil;

    protected void addRoleAttributes(Model model) {
        model.addAttribute("allAccessRoles", roleAccessUtil.getAllAccessRoles());
        model.addAttribute("generalAccessRoles", roleAccessUtil.getGeneralAccessRoles());
        model.addAttribute("labAccessRoles", roleAccessUtil.getLabAccessRoles());
        model.addAttribute("managerAccessRoles", roleAccessUtil.getManagerAccessRoles());
    }
}
