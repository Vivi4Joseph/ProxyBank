package org.formation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Personne implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String lastName;

	private String firstName;

	public Personne() {
	}

	public Personne(String nom, String prenom) {
		this.lastName = nom;
		this.firstName = prenom;
	}

	public Personne(Long id, String nom, String prenom) {
		this(nom, prenom);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Personne{" +
				"id=" + id +
				", nom='" + lastName + '\'' +
				", prenom='" + firstName + '\'' +
				'}';
	}
}
