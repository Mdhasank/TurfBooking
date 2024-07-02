package com.turf.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "First name can not be empty !!")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "User name must contain only alphabetic characters")
	@Size(min = 3, max = 15, message = "Last name must be between 3 and 15 characters")
	private String firstName;
	
	@NotBlank(message = "Last name can not be empty !!")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "User name must contain only alphabetic characters")
	@Size(min = 3, max = 15, message = "Last name must be between 3 and 15 characters")
	private String lastName;
	
	@Column(unique = true)
	@Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{3,}$", message = "Invalid email address format")
	private String email;
	
	@NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exactly 10 digits")
	private String phoneNumber;
	
	@NotBlank(message = "Address cannot be empty !!")
    @Size(min = 4, max = 30, message = "Address must be between 4 and 30 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Address must contain only alphanumeric characters")
	private String address;
	
	@NotBlank(message = "Password cannot be empty")
	private String password;
	private String role;

	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "customer") private List<Ground> grounds = new ArrayList<>();
	 */

}
