package repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DO.UserDO;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserDO, Integer>{

	UserDO findByFirstName(String fName);
	UserDO findByLastName (String lName);
	UserDO findByEmailId(String email);
//	UserDO findByUsername(String username);
	UserDO findByCityAndState(String city, String state);
	UserDO findByCityOrState(String city, String state);
}
