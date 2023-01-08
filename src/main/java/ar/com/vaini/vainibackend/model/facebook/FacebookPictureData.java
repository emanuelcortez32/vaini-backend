package ar.com.vaini.vainibackend.model.facebook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacebookPictureData {
    private String height;
    private String width;
    private String url;
}
