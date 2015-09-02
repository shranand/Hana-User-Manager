package com.deloitte.innovations.HanaUserManagementSystem;


import com.deloitte.innovations.usermanager.HanaCredentials;
import com.deloitte.innovations.usermanager.HanaUserManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String [] a={"hana01.dev.dci.local" ,"30115", "jaisebastian", "Welcome.1", "create", "testUser1212", "SAP_HANA_TEST_OPENSSO", "testIden1212", "PUBLIC"};
    	
    	HanaCredentials hdef=new HanaCredentials(a[0],a[1],a[2],a[3]);
		
		HanaUserManager hum=new HanaUserManager(hdef);
		
		if(hum.checkCon())System.out.println("Hana Table Connection Success");
		
		User tempUser=new User(a[5],a[6],a[7],a[8]);
		
		if(a[4].equals("create")){
							hum.createUser(tempUser);
							//if(tempUser.getRoles()!=null)
							//hum.updateUser(tempUser);
							
		}
		
		else if(a[4].equals("update")){
							hum.updateUser(tempUser);
		}
		
		else if(a[4].equals("delete")){
							hum.deleteUser(tempUser);
		}
		
		else System.out.println("Invalid Action Specified"); 
		
    }
}
