package ar.com.vaini.vainibackend.helpers;

import ar.com.vaini.vainibackend.controllers.responses.BadRequestResponse;
import ar.com.vaini.vainibackend.controllers.responses.NotAuthorizedResponse;
import ar.com.vaini.vainibackend.controllers.responses.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HelpersControllers {

    public static ResponseEntity createOkResponse(Object body) {
        return ResponseEntity.ok(SuccessResponse.builder()
                        .status(HttpStatus.OK)
                        .data(body)
                .build());
    }

    public static ResponseEntity createBadRequestResponse(Object body) {
        return ResponseEntity.badRequest().body(BadRequestResponse.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .message("BAD_REQUEST")
                        .error(body)
                .build());
    }

    public static ResponseEntity createUnAuthorizedResponse(Object body) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(NotAuthorizedResponse.builder()
                        .status(HttpStatus.UNAUTHORIZED)
                        .message("NOT_AUTHORIZED")
                        .error(body)
                .build());
    }
}
