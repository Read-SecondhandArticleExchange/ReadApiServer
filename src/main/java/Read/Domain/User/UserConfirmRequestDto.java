package Read.Domain.User;

import lombok.*;

/**
 * Created by seungki on 2017-07-25.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserConfirmRequestDto {
    long kakaoId;
    String profileUrl;
    String profileName;
}
