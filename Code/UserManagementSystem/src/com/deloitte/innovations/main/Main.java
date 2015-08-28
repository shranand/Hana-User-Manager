package com.deloitte.innovations.main;


import com.deloitte.innovations.usermanager.HanaCredentials;
import com.deloitte.innovations.usermanager.HanaUserManager;

public class Main {

	public static void main(String[] arg){
		
		
		
		/*
		for (String s: arg) {
            System.out.println(s);
        }
		*/
		
		String a[]={"hana01.dev.dci.local","30015","jaisebastian","Welcome.1","update","SHRANAND","SAP_HANA_TEST_OPENSSO","testIden1212","PUBLIC,PRIVATE"};
		HanaCredentials hdef=new HanaCredentials(a[0],a[1],a[2],a[3]);
											
		HanaUserManager hum=new HanaUserManager(hdef);
		
		if(hum.checkCon())System.out.println("Hana Table Connection Success");
		
		User tempUser=new User(a[5],a[6],a[7],a[8]);
		
		switch(a[4]){
		case "create":		hum.createUser(tempUser);
							if(tempUser.getRoles()!=null)
							hum.updateUser(tempUser);
							break;
							
		case "update":hum.updateUser(tempUser);break;
		case "delete":hum.deleteUser(tempUser);break;
		default :System.out.println("Invalid Action Specified"); break;
		}
		
		
		
		
		
	}
	
	
	
}
