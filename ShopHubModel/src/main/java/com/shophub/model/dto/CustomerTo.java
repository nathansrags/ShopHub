package com.shophub.model.dto;

import com.shophub.model.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomerTo extends UserTo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2657373358620962289L;
	private Long customerId;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;    
    private String age;
    private Gender gender;
    private String password;
    private Date dob;
    private MultipartFile image;
    private AddressTo billingAddress;
    private AddressTo shippingAddress;
}
