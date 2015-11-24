package com.espark.adarsh.cas.web.security;


import com.espark.adarsh.cas.persistence.entities.User;
import com.espark.adarsh.cas.web.service.UserService;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.UnknownUsernameAuthenticationException;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;

@Service
public class ApplicationAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    @Autowired
    private UserService userService;

    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential usernamePasswordCredential)
            throws GeneralSecurityException, PreventedException {

        String userName = usernamePasswordCredential.getUsername();
        String password = usernamePasswordCredential.getPassword();

        User user = userService.getUserByUserName(userName,password);
        if(user == null) {
            try {
                throw new UnknownUsernameAuthenticationException("User " + userName + " not found");
            } catch (UnknownUsernameAuthenticationException e) {
                e.printStackTrace();
            }
        }
        return createHandlerResult(usernamePasswordCredential, new SimplePrincipal(userName), null);
    }
}
