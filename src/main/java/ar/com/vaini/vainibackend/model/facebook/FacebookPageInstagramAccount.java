package ar.com.vaini.vainibackend.model.facebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacebookPageInstagramAccount {
    @JsonProperty("id")
    private String id;

    @JsonProperty("instagram_business_account")
    private InstagramBusinessAccount instagramBusinessAccount;

}
