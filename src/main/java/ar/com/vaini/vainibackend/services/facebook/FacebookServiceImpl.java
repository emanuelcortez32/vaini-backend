package ar.com.vaini.vainibackend.services.facebook;

import ar.com.vaini.vainibackend.client.FacebookClient;
import ar.com.vaini.vainibackend.model.Role;
import ar.com.vaini.vainibackend.model.UserDetails;
import ar.com.vaini.vainibackend.helpers.HelpersSecurity;
import ar.com.vaini.vainibackend.model.facebook.*;
import ar.com.vaini.vainibackend.security.JwtTokenProvider;
import ar.com.vaini.vainibackend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FacebookServiceImpl implements FacebookService {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private FacebookClient facebookClient;

    @Autowired
    private JwtTokenProvider tokenProvider;

    public String authUser(String facebookToken) throws Exception {

        FacebookUserProfile facebookUserProfile = facebookClient.getFacebookUserProfile(facebookToken);
        Set<String> baseRoles = new HashSet<>(){{
            add(Role.FACEBOOK_USER.getName());
            add(Role.MANAGE_ORDERS.getName());
        }};

        return userServiceImpl.findUserById(facebookUserProfile.getIdUser())
                .or(() -> Optional.ofNullable(userServiceImpl.registerUser(HelpersSecurity.convertToUser(facebookUserProfile), baseRoles)))
                .map(UserDetails::new)
                .map(userDetails -> new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()))
                .map(usernamePasswordAuthenticationToken -> {
                    try {
                        return tokenProvider.generateToken(usernamePasswordAuthenticationToken);
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new Exception("unable to login facebook user id " + facebookUserProfile.getIdUser()));
    }
    public FacebookPageAccount getPages(String facebookToken) throws Exception {
       return facebookClient.getFacebookUserPages(facebookToken);
    }

    public FacebookUserProfile getProfile(String facebookToken) throws Exception {
        return facebookClient.getFacebookUserProfile(facebookToken);
    }

    @Override
    public FacebookPageInstagramAccount getFacebookPageInstagramBusinessAccounts(String idPage, String facebookToken) throws Exception {
        return facebookClient.getFacebookPageInstagramBusinessAccounts(idPage, facebookToken);
    }

    @Override
    public InstagramUserProfile getInstagramUserProfile(String idUser, String facebookToken) throws Exception {
        return facebookClient.getInstagramUserProfile(idUser, facebookToken);
    }
}
