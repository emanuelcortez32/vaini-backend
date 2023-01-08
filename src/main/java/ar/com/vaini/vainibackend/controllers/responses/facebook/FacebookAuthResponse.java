package ar.com.vaini.vainibackend.controllers.responses.facebook;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class FacebookAuthResponse {
    @NonNull
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType = "Bearer";

    @NonNull
    @JsonProperty("expiration_time")
    private Long expiration;
}
