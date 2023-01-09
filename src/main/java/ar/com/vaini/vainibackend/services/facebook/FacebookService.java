package ar.com.vaini.vainibackend.services.facebook;

import ar.com.vaini.vainibackend.model.facebook.*;

public interface IFacebookService {
    String authUser(String facebookToken) throws Exception;

    FacebookPageAccount getPages(String facebookToken) throws Exception;

    FacebookUserProfile getProfile(String facebookToken) throws Exception;

    FacebookPageInstagramAccount getFacebookPageInstagramBusinessAccounts(String idPage, String facebookToken) throws Exception;

    InstagramUserProfile getInstagramUserProfile(String idUser, String facebookToken) throws Exception;
}
