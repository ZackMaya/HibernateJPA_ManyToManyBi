package mx.edu.uacm.primerproyectohbm.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;
	
	private String street;
	
	private String number;
	
	private String postalCode;
	
	@ManyToMany(mappedBy="addresses")
	private List<Person> owners = new ArrayList<>();
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(String street, String number, String postalCode) {
		this.street = street;
		this.number = number;
		this.postalCode = postalCode;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the owners
	 */
	public List<Person> getOwners() {
		return owners;
	}

	/**
	 * @param owners the owners to set
	 */
	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}
	
	
	
}
