package com.applet.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SysAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<SysRole> roles;
    @OneToOne
    private SysAdminInfo adminInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public SysAdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(SysAdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }
}
