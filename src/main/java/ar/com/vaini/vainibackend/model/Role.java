package ar.com.vaini.vainibackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    public final static Role FACEBOOK_USER = new Role("ROLE_FACEBOOK_USER");
    public final static Role MANAGE_CATALOG_PRODUCTS = new Role("MANAGE_CATALOG_PRODUCTS");
    public final static Role MANAGE_MESSAGES = new Role("MANAGE_MESSAGES");
    public final static Role MANAGE_PAYMENT = new Role("MANAGE_PAYMENT");
    public final static Role MANAGE_ADS = new Role("MANAGE_ADS");
    public final static Role MANAGE_DELIVERY = new Role("MANAGE_DELIVERY");
    public final static Role MANAGE_ORDERS = new Role("MANAGE_ORDERS");
    private String name;
}
