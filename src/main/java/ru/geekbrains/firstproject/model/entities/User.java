package ru.geekbrains.firstproject.model.entities;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "users")
@Data
public class User {

    public User() {
        this.roles = new ArrayList<Role>();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "delete_at")
    private LocalDateTime delete_at;

    @OneToOne(mappedBy = "owner", optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserDetail userDetail;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

}
