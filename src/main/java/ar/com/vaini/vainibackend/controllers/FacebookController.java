package ar.com.vaini.vainibackend.controllers;

import ar.com.vaini.vainibackend.controllers.responses.facebook.BusinessAccountsResponse;
import ar.com.vaini.vainibackend.controllers.responses.facebook.FacebookAuthResponse;
import ar.com.vaini.vainibackend.helpers.HelpersControllers;
import ar.com.vaini.vainibackend.model.facebook.*;
import ar.com.vaini.vainibackend.security.JwtTokenProvider;
import ar.com.vaini.vainibackend.services.facebook.FacebookService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/services/facebook")
public class FacebookController {

    @Autowired
    private FacebookService facebookService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @GetMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authFacebookUser(@RequestHeader(value = "Authorization-FB") String facebookToken, HttpSession httpSession) throws Exception {
        if(facebookToken.isBlank() || facebookToken.isEmpty()) return HelpersControllers.createBadRequestResponse("Value for header Authorization-FB can't be empty or blank");
        httpSession.setAttribute("Authorization-FB", facebookToken);
        String token = facebookService.authUser(facebookToken);
        Claims claims = tokenProvider.getClaimsFromJWT(token);
        return HelpersControllers.createOkResponse(new FacebookAuthResponse(token, claims.getExpiration().getTime()));
    }

    @GetMapping(path = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFacebookProfile(HttpSession httpSession) throws Exception {
        String facebookToken = httpSession.getAttribute("Authorization-FB").toString();
        if(facebookToken == null || facebookToken.isEmpty() || facebookToken.isBlank()) return HelpersControllers.createUnAuthorizedResponse("You must be logged");
        FacebookUserProfile profile = facebookService.getProfile(facebookToken);
        return HelpersControllers.createOkResponse(profile);
    }

    @GetMapping(path = "/businesses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFacebookBusinesses(HttpSession httpSession) throws Exception {
        String facebookToken = httpSession.getAttribute("Authorization-FB").toString();
        if(facebookToken == null || facebookToken.isEmpty() || facebookToken.isBlank()) return HelpersControllers.createUnAuthorizedResponse("You must be logged");
        FacebookPageAccount facebookPages = facebookService.getPages(facebookToken);
        List<BusinessAccountsResponse> businessAccounts = facebookPages.getData().stream()
                .map(facebookPage -> {
                    try {
                        FacebookPageInstagramAccount facebookPageInstagramAccount = facebookService.getFacebookPageInstagramBusinessAccounts(facebookPage.getId(), facebookToken);
                        InstagramUserProfile instagramUserProfile = facebookService.getInstagramUserProfile(facebookPageInstagramAccount.getInstagramBusinessAccount().getId(), facebookToken);
                        return BusinessAccountsResponse.builder()
                                .facebookAccountData(facebookPage)
                                .instagramBusinessAccount(InstagramBusinessAccountComplete.builder()
                                        .id(facebookPageInstagramAccount.getInstagramBusinessAccount().getId())
                                        .instagramUserProfile(instagramUserProfile)
                                        .build())
                                .build();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).toList();

        return HelpersControllers.createOkResponse(businessAccounts);
    }
}
