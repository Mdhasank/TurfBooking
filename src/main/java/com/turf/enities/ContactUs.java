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
public class ContactUs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "User name can not be empty !!")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "User name must contain only alphabetic characters")
	private String name;

	@Column(unique = true)
	@Email(regexp = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-.]+$)", message = "Please provide a valid email address !")
	private String email;

	@NotBlank(message = "Message can be empty !!")
	@Size(min = 4, max = 100, message = "Message name must be between 4 - 100 characters")
	private String message;
}
