package DO;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class RoleDO {

	@Id
	private Long id;
    private String name;
//    private Set<UserDO> users;
	public RoleDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleDO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
//		this.users = users;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*@ManyToMany(mappedBy = "roles")
	public Set<UserDO> getUsers() {
		return users;
	}
	public void setUsers(Set<UserDO> users) {
		this.users = users;
	}*/
    
    
}
