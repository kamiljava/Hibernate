package model;

import javax.management.relation.Role;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
import java.util.Set;

@Entity
public class User1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_u;

    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
            @JoinTable(name = "user1_role1")
    Set<Role1> roles = new HashSet<>();

    private boolean enable;
    private LocalDate date_add = LocalDate.now();

    @Transient
    private String secrete_code;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "user1")
    List<Post1> posts = new ArrayList<>();

    public User1() {
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role1> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role1> roles) {
        this.roles = roles;
    }
    public void addRolesToSet(Role1 role1){
        this.roles.add(role1);
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public LocalDate getDate_add() {
        return date_add;
    }

    public void setDate_add(LocalDate date_add) {
        this.date_add = date_add;
    }

    public String getSecrete_code() {
        return secrete_code;
    }

    public void setSecrete_code(String secrete_code) {
        this.secrete_code = secrete_code;
    }

    public List<Post1> getPosts() {
        return posts;
    }

    public void setPosts(List<Post1> posts) {
        this.posts = posts;
    }

    public User1(String email, String password) {
        this.email = email;
        this.password = password;
    }
}