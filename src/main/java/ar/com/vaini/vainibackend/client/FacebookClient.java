package ar.com.vaini.vainibackend.client;

import ar.com.vaini.vainibackend.model.facebook.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class FacebookClient {

    @Value("${facebook.api.base}")
    private String apiBase;

    @Value("${facebook.api.version}")
    private String versionApi;

    @Autowired
    private RestTemplate restTemplate;

    public FacebookUserProfile getFacebookUserProfile(String facebookToken) {
        String path = "/me?fields={fields}&redirect={redirect}&access_token={access_token}";
        List<String> fields = new ArrayList<>(Arrays.asList(
                "email",
                "first_name",
                "last_name",
                "id",
                "picture.width(720).height(720)"
        ));

        final Map<String, String> variables = new HashMap<>();

        variables.put("fields", String.join(",", fields));
        variables.put("redirect","false");
        variables.put("access_token", facebookToken);

        return restTemplate.getForObject(apiBase + versionApi + path, FacebookUserProfile.class, variables);
    }


    public FacebookPageAccount getFacebookUserPages(String facebookToken) {
        String path = "/me/accounts?access_token={access_token}";
        final Map<String, String> variables = new HashMap<>(){{
            put("access_token", facebookToken);
        }};

        return restTemplate.getForObject(apiBase + versionApi + path, FacebookPageAccount.class, variables);
    }

    public FacebookPageInstagramAccount getFacebookPageInstagramBusinessAccounts(String idPage, String facebookToken) {
        String path = "/{id_page}?fields={fields}&access_token={access_token}";
        List<String> fields = new ArrayList<>(List.of(
                "instagram_business_account"
        ));
        final Map<String, String> variables = new HashMap<>(){{
            put("id_page", idPage);
            put("access_token", facebookToken);
            put("fields", String.join(",", fields));
        }};

        return restTemplate.getForObject(apiBase + versionApi + path, FacebookPageInstagramAccount.class, variables);
    }

    public InstagramUserProfile getInstagramUserProfile(String userId, String facebookToken) {
        String path = "/{ig-user-id}?fields={fields}&access_token={access_token}";
        List<String> fields = new ArrayList<>(List.of(
                "id",
                "name",
                "username",
                "website",
                "biography",
                "profile_picture_url",
                "shopping_product_tag_eligibility"
        ));
        final Map<String, String> variables = new HashMap<>(){{
            put("ig-user-id", userId);
            put("access_token", facebookToken);
            put("fields", String.join(",", fields));
        }};

        return restTemplate.getForObject(apiBase + versionApi + path, InstagramUserProfile.class, variables);
    }

}
