package com.applet.entity;

import javax.persistence.*;

@Entity
public class SysCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Long level;
    @OneToOne
    private SysAdmin admin;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public SysAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(SysAdmin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SysCategory{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", level=").append(level);
        sb.append(", admin=").append(admin);
        sb.append('}');
        return sb.toString();
    }
}
