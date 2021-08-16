package eql.al.demo.entites;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "school")
@NamedQueries({
	@NamedQuery(name = "school.findAll" ,query ="SELECT s FROM SchoolEntityManager s"),
    @NamedQuery(name="getXContact", query="SELECT s FROM SchoolEntityManager s WHERE s.name = :name")
})
public class SchoolEntityManager {
	@Id
	//@org.hibernate.annotations.GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

    private String phone;
    
    private String email;
    
    private String address1;
    
    @Column(length = 4000)
    private String note; 

	public SchoolEntityManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "SchoolEntityManager [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", address1=" + address1 + ", note=" + note + "]";
	}
	

}
