package ar.com.vaini.vainibackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    public final static Role FACEBOOK_USER = new Role("ROLE_FACEBOOK_USER");
    public final static Role MANAGE_ORDERS = new Role("ROLE_MANAGE_ORDERS");
    private String name;
}
