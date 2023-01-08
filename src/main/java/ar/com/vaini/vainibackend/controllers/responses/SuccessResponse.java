package ar.com.vaini.vainibackend.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class SuccessResponse {

    @JsonProperty("status")
    protected HttpStatus status;

    @JsonProperty("data")
    private Object data;
}
