package com.espark.adarsh.cas.web.security.persondir;

import org.jasig.services.persondir.support.BasePersonImpl;

import java.util.List;
import java.util.Map;

public class ApplicationPersonAttributes extends BasePersonImpl{

	private final String userNameAttribute = new String("userName");

	public ApplicationPersonAttributes(Map<String, List<Object>> attributes) {
		super(attributes);
	}

	public String getName() {
		final Object attributeValue = this.getAttributeValue(this.userNameAttribute);
        if (attributeValue == null) { 
            return null;
        }
        return attributeValue.toString();
	}


}
