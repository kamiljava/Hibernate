package model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_u;

    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated
    private RoleEnum role;
    private boolean enable;

    private LocalDate date_add = LocalDate.now();

    @Transient
    private String secrete_code;


    public User() {
    }

    public User(String email, String password, RoleEnum role, boolean enable, LocalDate date_add, String secrete_code) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.enable = enable;
        this.date_add = date_add;
        this.secrete_code = secrete_code;
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

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
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
}