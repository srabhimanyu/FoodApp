package com.phegon.FoodApp.auth_users.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String profileURL;
    private String address;
    private boolean isActive;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="users_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private List<Role> roles;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Payment> payments;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Cart cart;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
