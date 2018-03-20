package com.applet.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "`desc`")
    private String desc;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(joinColumns = {@JoinColumn(name = "access_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<SysAccess> accesses;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")
    private List<SysAdmin> admins;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<SysAccess> getAccesses() {
        return accesses;
    }

    public void setAccesses(List<SysAccess> accesses) {
        this.accesses = accesses;
    }

    public List<SysAdmin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<SysAdmin> admins) {
        this.admins = admins;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SysRole{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", accesses=").append(accesses);
        sb.append(", admins=").append(admins);
        sb.append('}');
        return sb.toString();
    }
}
