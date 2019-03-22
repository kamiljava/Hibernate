package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_u;

    private String email;
    private String password;
    private String role;
    private boolean enable;
    private LocalDate date_add;

    public User(String email, String password, String role, boolean enable, LocalDate date_add) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.enable = enable;
        this.date_add = date_add;
    }

    public User() {

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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
}

