package gr.codehub.crminnovative.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CustomerDto {

    private int id;
    private String firstname;
    private String lastname;
    private String street;
    private String number;
    private String vatNumber;
    private String email;
    private Date registrationDate;
    private Date dob;
}
