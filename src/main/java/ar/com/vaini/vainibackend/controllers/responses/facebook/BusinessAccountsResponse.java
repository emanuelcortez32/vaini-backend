package ar.com.vaini.vainibackend.controllers.responses.facebook;

import ar.com.vaini.vainibackend.model.facebook.FacebookAccountData;
import ar.com.vaini.vainibackend.model.facebook.InstagramBusinessAccountComplete;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessAccountsResponse {
    @JsonProperty("facebook_page")
    private FacebookAccountData facebookAccountData;

    @JsonProperty("instagram_account")
    private InstagramBusinessAccountComplete instagramBusinessAccount;
}
