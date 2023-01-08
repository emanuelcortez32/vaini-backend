package ar.com.vaini.vainibackend.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public User(User user) {
        this.id = user.id;
        this.name = user.name;
        this.lastName = user.lastName;
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.active = user.active;
        this.roles = user.roles;
    }
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Set<Role> roles;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean active;
}
