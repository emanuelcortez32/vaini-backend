package ar.com.vaini.vainibackend.model.facebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstagramUserProfile {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("username")
    private String username;

    @JsonProperty("website")
    private String website;

    @JsonProperty("biography")
    private String biography;

    @JsonProperty("profile_picture_url")
    private String profilePicture;

    @JsonProperty("shopping_product_tag_eligibility")
    private boolean enableShopping;
}
