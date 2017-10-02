package services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DO.UserDO;
import VO.UserVO;
import repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<UserDO> getAllUsers() {
		return userRepository.findAll();
	}

	public UserDO getUserBasedOnId(int id) {
		return userRepository.findOne(id);
	}

	
	
	public void addUser(UserDO user) {
		userRepository.save(user);
	}
	
	

	/*@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDO user = userRepository.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (RoleDO role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getFirstName() + ""+user.getLastName(), user.getPassword(),
				grantedAuthorities);
	}*/

	public UserDO getUserByCityAndState(String city, String state) {
		// TODO Auto-generated method stub
		return userRepository.findByCityAndState(city,state);
		
	}

	public UserDO getUserByCityOrState(String city, String state) {
		// TODO Auto-generated method stub
		return userRepository.findByCityOrState(city,state);
	}
}
