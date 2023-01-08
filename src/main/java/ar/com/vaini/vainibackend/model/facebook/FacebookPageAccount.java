package ar.com.vaini.vainibackend.model.facebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FacebookPageAccount {

    @JsonProperty("data")
    private List<FacebookAccountData> data;
}
