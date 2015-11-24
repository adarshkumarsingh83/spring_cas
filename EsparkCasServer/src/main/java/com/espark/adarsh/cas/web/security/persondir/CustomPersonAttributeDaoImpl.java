package com.espark.adarsh.cas.web.security.persondir;


import com.espark.adarsh.cas.persistence.entities.Role;
import com.espark.adarsh.cas.persistence.entities.User;
import com.espark.adarsh.cas.web.service.UserService;
import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.AbstractFlatteningPersonAttributeDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CustomPersonAttributeDaoImpl extends AbstractFlatteningPersonAttributeDao {
	private String ROLE_PREFIX = "ROLE_";

    @Autowired
	private UserService userService;
	
	/*private Map<String, Set<String>> resultAttributeMapping;
	
	public Map<String, Set<String>> getResultAttributeMapping() {
		return resultAttributeMapping;
	}

	public void setResultAttributeMapping(
			Map<String, Set<String>> resultAttributeMapping) {
		this.resultAttributeMapping = resultAttributeMapping;
	}*/

	public IPersonAttributes getPerson(String uid) {
		User user = userService.getUserByUserName(uid);
		
        Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();
        List<Object> nameList = new ArrayList<Object>();
        nameList.add(user.getUserName());
        attributes.put("userName", nameList);
        
        List<Object> emailList = new ArrayList<Object>();
        emailList.add(user.getEmail());
        attributes.put("email", emailList);
        
        List<Object> rolesList = new ArrayList<Object>();
        rolesList.addAll(getRolesList(user.getRoles()));
        attributes.put("roles", rolesList);
        
        ApplicationPersonAttributes apa = new ApplicationPersonAttributes(attributes);
        return apa;
	}
	
	protected List<String> getRolesList(Set<Role> rolesList) {
		List<String> roles = new ArrayList<String>();
		for(Role role : rolesList) {
			roles.add(ROLE_PREFIX + role.getName());
			for(String permission : role.getPermissions()) {
				roles.add(ROLE_PREFIX + permission);
			}
		}
		return roles;
	}

	public Set<IPersonAttributes> getPeopleWithMultivaluedAttributes(
			Map<String, List<Object>> query) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getPossibleUserAttributeNames() {
		Set<String> possibleAttributeNames = new HashSet<String>();
		possibleAttributeNames.add("userName");
		possibleAttributeNames.add("email");
		possibleAttributeNames.add("roles");
		return possibleAttributeNames;
	}

	public Set<String> getAvailableQueryAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	public Map<String, List<Object>> getBackingMap() {
		return this.backingPerson.getAttributes();
	}*/
}
