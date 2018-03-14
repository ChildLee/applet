package com.applet.entity;

import javax.persistence.*;

@Entity
public class SysAdminInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private SysAdmin admin;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SysAdminInfo{");
        sb.append("id=").append(id);
        sb.append(", admin=").append(admin);
        sb.append('}');
        return sb.toString();
    }
}
