package com.applet.entity;

import javax.persistence.*;

@Entity
public class SysAdminInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private SysAdmin admin;
    private String app_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SysAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(SysAdmin admin) {
        this.admin = admin;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SysAdminInfo{");
        sb.append("id=").append(id);
        sb.append(", admin=").append(admin);
        sb.append(", app_id='").append(app_id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
