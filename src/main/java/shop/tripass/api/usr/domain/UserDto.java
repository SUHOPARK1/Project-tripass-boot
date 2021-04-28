package shop.tripass.api.usr.domain;

import io.opencensus.common.Timestamp;
import lombok.Data;

@Data
public class UserDto {

    private long num;
    private String role;
    private String provider;
    private String providerId;
    private String username;
    private String email;
    private String age;
    private String gender;
    private String password;


    public UserDto(User user) {
        this.num = user.getNum();
        this.role = user.getRole();
        this.provider = user.getProvider();
        this.providerId = user.getProviderId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.password = user.getPassword();
    }
}