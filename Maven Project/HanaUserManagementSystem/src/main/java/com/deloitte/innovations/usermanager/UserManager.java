package com.deloitte.innovations.usermanager;




import com.deloitte.innovations.HanaUserManagementSystem.User;

public interface UserManager {
	
	void createUser(User tempUser);
	void updateUser(User tempUser);
	void deleteUser(User tempUser);

}
