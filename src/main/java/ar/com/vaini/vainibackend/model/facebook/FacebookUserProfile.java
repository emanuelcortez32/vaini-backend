package ar.com.vaini.vainibackend.model.facebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FacebookUserProfile {

    @JsonProperty("email")
    private String email;
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("id")
    private String idUser;

    @JsonProperty("avatar")
    private FacebookPicture picture;
}
