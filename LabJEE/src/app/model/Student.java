package app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private Integer student_id;
	@Column(nullable = false, length = 50)
	private String imie;
	@Column(nullable = false, length = 100)
	private String nazwisko;
	@Column(unique = true, length = 20)
	private String nrIndeksu;
	@Column()
	private String email;
	@Column(nullable = false)
	private Boolean stacjonarny;
	
	@ManyToMany(mappedBy = "studenci") 
	private Set<Projekt> projekty;


	
public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNrIndeksu() {
		return nrIndeksu;
	}

	public void setNrIndeksu(String nrIndeksu) {
		this.nrIndeksu = nrIndeksu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStacjonarny() {
		return stacjonarny;
	}

	public void setStacjonarny(Boolean stacjonarny) {
		this.stacjonarny = stacjonarny;
	}

	public Set<Projekt> getProjekty() {
		return projekty;
	}

	public void setProjekty(Set<Projekt> projekty) {
		this.projekty = projekty;
	}

public Student() {
}

public Student(String imie, String nazwisko, String nrIndeksu) 
{
	this.imie = imie;
	this.nazwisko = nazwisko; 
	this.nrIndeksu = nrIndeksu;
}

public Student(String imie, String nazwisko, String nrIndeksu, String email, Boolean stacjonarny) {
{
	this.imie = imie; 
	this.nazwisko = nazwisko; 
	this.nrIndeksu = nrIndeksu; 
	this.email = email; 
	this.stacjonarny = stacjonarny;
}
}}