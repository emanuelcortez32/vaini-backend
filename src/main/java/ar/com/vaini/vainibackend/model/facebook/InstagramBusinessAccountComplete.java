package ar.com.vaini.vainibackend.model.facebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstagramBusinessAccountComplete {

    @JsonProperty("id")
    private String id;

    @JsonProperty("user_profile")
    private InstagramUserProfile instagramUserProfile;
}
