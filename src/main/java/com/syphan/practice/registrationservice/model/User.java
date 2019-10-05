package com.syphan.practice.registrationservice.model;

import com.syphan.practice.commonservice.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_social")
    private String userSocial;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String avatar;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "roles_users",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id", nullable = false))
    private Set<Role> roles = new HashSet<>();
}
