package ar.com.vaini.vainibackend.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class BadRequestResponse {

    @JsonProperty("status")
    protected HttpStatus status;

    @JsonProperty("message")
    private Object message;

    @JsonProperty("error")
    private Object error;
}
