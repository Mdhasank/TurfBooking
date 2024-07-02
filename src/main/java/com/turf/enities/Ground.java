package com.turf.enities;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ground {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String description;
	private double width;
	private double length;
	private double height;
	private int price;
	private String category;
	private Boolean isActive;
	private String image;
	
	@OneToMany(mappedBy = "ground")
    private List<Booking> bookings;
	
	/*
	 * @ManyToOne private Customer customer;
	 */
	

}
