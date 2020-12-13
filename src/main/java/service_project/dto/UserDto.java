package service_project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import service_project.model.AccountStatus;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Size(min = 5)
    private String username;
    private String confirmedPassword;

    @Size(min = 5)
    private String password;
    private String city;
    private String address;
    private Date createDate;
    private AccountStatus status;
    private byte[] avatar;
}
