package DO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserDO {

	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String city;
	private String state;
	private String country;
	private String password;
//	private HashSet<RoleDO> roles;
	
	public UserDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDO(int id, String firstName, String lastName, String emailId, String city, String state,
			String country) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*@ManyToMany
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name ="user_id"),inverseJoinColumns = @JoinColumn(name = "roles_id"))
	public HashSet<RoleDO> getRoles() {
		return roles;
	}
	public void setRoles(HashSet<RoleDO> roles) {
		this.roles = roles;
	}*/
	
}
