package com.deloitte.innovations.usermanager;




import java.sql.ResultSet;

import java.util.Arrays;
import java.util.List;

import com.deloitte.innovations.helper.SQLHanaHelper;
import com.deloitte.innovations.main.User;

public class HanaUserManager implements UserManager {
	SQLHanaHelper sqlHanaHelper;
	
	
	
	
	
	
	
	public HanaUserManager(HanaCredentials tabDef) {
		super();
		sqlHanaHelper=new SQLHanaHelper(tabDef.getHANA_HOST(),tabDef.getHANA_PORT(),tabDef.getHANA_TECH_USERNAME(),tabDef.getHANA_TECH_PWD());
		
	}
	
	

	@Override
	public void createUser(User tempUser) {
		// TODO Auto-generated method stub
		
		String query="CREATE USER "+tempUser.getName()+" WITH IDENTITY '"+tempUser.getIdentity()+"' FOR SAML PROVIDER "+tempUser.getIDPName();
		try {
			sqlHanaHelper.execute(query);
			System.out.println("Successfully Created User.");
			sqlHanaHelper.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("In HanaUserManager, CreateUser:");
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(User tempUser) {
		// TODO Auto-generated method stub
		String query_get="SELECT ROLE_NAME FROM GRANTED_ROLES WHERE GRANTEE LIKE '"+tempUser.getName()+"'";
		//List<String> granted_roles = new ArrayList<String>();
		String grantedRoles="";
		//String query_revoke="REVOKE "+"ALL PRIVILEGES"+" FROM "+tempUser.getName();
		//String query="GRANT "+tempUser.getRoles().toString().replace("[", "\"").replace("]", "\"").replace(", ", "\", \"")+" TO "+tempUser.getName();
		//System.out.println("Revoke query: "+query_revoke);
		try {ResultSet rs =sqlHanaHelper.execute(query_get);
		while(rs.next()){
			grantedRoles+=rs.getString(1)+",";
		}
		List<String> granted_roles = Arrays.asList(grantedRoles.split("\\s*,\\s*"));
		
		for(String temp_role:granted_roles){
			if(tempUser.getRoles().indexOf(temp_role)==-1){//Revoke Here 
															System.out.println("Revoking: "+ temp_role);
															String query="REVOKE "+temp_role+" FROM "+tempUser.getName();
															sqlHanaHelper.execute(query);
															}
			}
		
		for(String temp_role:tempUser.getRoles()){
			if(granted_roles.indexOf(temp_role)==-1){//Revoke Here 
				System.out.println("Granting: "+ temp_role);
				String query="GRANT "+temp_role+" TO "+tempUser.getName();
				sqlHanaHelper.execute(query);
				}
		}
		//grant 
		
		
		
		sqlHanaHelper.closeConnection();
		//System.out.println("Successfully Revoked User.");
			//sqlHanaHelper.execute(query);
			//System.out.println("Successfully Updated User.");
			//sqlHanaHelper.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("In HanaUserManager, UpdateUser:");
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void deleteUser(User tempUser) {
		// TODO Auto-generated method stub
		String query="DROP USER "+tempUser.getName();
		try {
			sqlHanaHelper.execute(query);
			System.out.println("Successfully Deleted User.");
			sqlHanaHelper.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("In HanaUserManager, DeleteUser:");
			e.printStackTrace();
		}
		
	}
	
	
	public boolean checkCon() {
		// TODO Auto-generated method stub
		return sqlHanaHelper.isConnectionOpen();
		
	}

}
