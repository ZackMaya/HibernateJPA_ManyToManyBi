package mx.edu.uacm.primerproyectohbm.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NaturalId;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	@NaturalId
	private String resgistrationNumber;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Address> addresses = new ArrayList<>();

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String regNumber) {
		this.resgistrationNumber = regNumber;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the resgistrationNumber
	 */
	public String getResgistrationNumber() {
		return resgistrationNumber;
	}

	/**
	 * @param resgistrationNumber
	 *            the resgistrationNumber to set
	 */
	public void setResgistrationNumber(String resgistrationNumber) {
		this.resgistrationNumber = resgistrationNumber;
	}

	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void addAddress(Address address) {
		addresses.add(address);
		address.getOwners().add(this);
	}
	
	public void removeAddress(Address address) {
		addresses.remove(address);
		address.getOwners().remove(this);
	}
	
}
