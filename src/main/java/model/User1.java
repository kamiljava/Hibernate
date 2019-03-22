package model;

import javax.management.relation.Role;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
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


    public User1() {
    }

}