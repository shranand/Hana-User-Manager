package com.deloitte.innovations.HanaUserManagementSystem;


import com.deloitte.innovations.usermanager.HanaCredentials;
import com.deloitte.innovations.usermanager.HanaUserManager;

/**
 * HANA USER MANAGER
 *
 */
public class App 
{
    public static void main( String[] a )
    {
    	
    	
    	HanaCredentials hdef=new HanaCredentials(a[0],a[1],a[2],a[3]);
		
		HanaUserManager hum=new HanaUserManager(hdef);
		
		if(a.length==8)a[8]="";
		if(hum.checkCon()){System.out.println("Hana Table Connection Success.");
		
		User tempUser=new User(a[5],a[6],a[7],a[8]);
		
		if(a[4].equals("create")){
							hum.createUser(tempUser);
							if(tempUser.getRoles()!=null||a[8]!="")
							hum.updateUser(tempUser);
							
		}
		
		else if(a[4].equals("update")){
							hum.updateUser(tempUser);
		}
		
		else if(a[4].equals("delete")){
							hum.deleteUser(tempUser);
		}
		
		else System.out.println("Invalid Action Specified"); 
		}
		else System.out.println("Hana Table Connection Failure.") ;
    }
}
