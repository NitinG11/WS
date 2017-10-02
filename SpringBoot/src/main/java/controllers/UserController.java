package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DO.UserDO;
import VO.ServiceResultVO;
import VO.UserVO;
import services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/user/{id}")
	public HttpEntity<ServiceResultVO<UserVO>> getUser(@PathVariable("id") int id) {
		ServiceResultVO oServiceResultVO = new ServiceResultVO<>();
		try{
			if(id > 0){
				oServiceResultVO.setStatusCode(200);
				oServiceResultVO.setStatus("Success");
				oServiceResultVO.setData(userService.getUserBasedOnId(id));
			}
		}catch(Exception oDataException){
			oServiceResultVO.setStatusCode(400);
			oServiceResultVO.setStatus("error");
			System.out.println("exception while fetching data");
		}
		return new HttpEntity<ServiceResultVO<UserVO>>(oServiceResultVO);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public HttpEntity<ServiceResultVO<UserVO>> saveUser(@RequestBody UserVO userVO) {
		ServiceResultVO oServiceResultVO = new ServiceResultVO<>();
		try{
			UserDO user = new UserDO(userVO.getId(),userVO.getFirstName(),userVO.getLastName(),userVO.getEmailId(),userVO.getCity(),userVO.getState(),userVO.getCountry());
			oServiceResultVO.setStatusCode(200);
			oServiceResultVO.setStatus("Success");
			userService.addUser(user);
		}catch(Exception oDataException){
			oServiceResultVO.setStatusCode(400);
			oServiceResultVO.setStatus("error");
			System.out.println("exception while fetching data");
		}

		return new HttpEntity<ServiceResultVO<UserVO>>(oServiceResultVO);
	}
	
	@RequestMapping(value = "/user/cit")
	public HttpEntity<ServiceResultVO<UserVO>> findUser(@RequestParam("city") String city ,@RequestParam("state") String state ) {
		ServiceResultVO oServiceResultVO = new ServiceResultVO<>();
		UserDO user = new UserDO();
		try {
			if(city.length()>0 && state.length()>0) {
				user = userService.getUserByCityAndState(city,state);
			}else {
				user = userService.getUserByCityOrState(city,state);
			}
			oServiceResultVO.setStatusCode(200);
			oServiceResultVO.setStatus("Success");
			oServiceResultVO.setData(user);
		}catch (Exception e) {
			oServiceResultVO.setStatusCode(400);
			oServiceResultVO.setStatus("error");
			System.out.println("exception while fetching data");
		}
		return new HttpEntity<ServiceResultVO<UserVO>>(oServiceResultVO);
		
	}
}
