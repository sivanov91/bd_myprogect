package com.myproject.web.service;

import com.myproject.web.dao.UserDAO;
import com.myproject.web.util.Factory;
import org.apache.log4j.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {
	
	protected static Logger logger = Logger.getLogger("service");
    private UserDAO userDAO = Factory.getUserDAO();

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

        //System.out.println(username);
		
		// Declare a null Spring User
		UserDetails user = null;
		
		try {
			
			// Search database for a user that matches the specified username
			// You can provide a custom DAO to access your persistence layer
			// Or use JDBC to access your database
			// DbUser is our custom domain user. This is not the same as Spring's User
			com.myproject.web.domain.User dbUser = userDAO.getByUserName(username);
			System.out.println(dbUser.getUserName());
			// Populate the Spring User object with details from the dbUser
			// Here we just pass the username, password, and access level
			// getAuthorities() will translate the access level to the correct role type


            String pass = dbUser.getPassword().toLowerCase().replaceAll("^|\\s*(\\w+)\\s*|$", "$1");
            //example.replaceAll("^|\\s*(\\w+)\\s*|$", "$1")
            //String pass ="21232f297a57a5a743894a0e4a801fc3";

            System.out.printf("name: %s pass: %s\n", dbUser.getUserName(), dbUser.getPassword().toLowerCase());

			user =  new User(
					dbUser.getUserId().toString(),
					pass,
					true,
					true,
					true,
					true,
					getAuthorities(1) );

		} catch (Exception e) {
			//System.out.println("Error mazafaka");
            logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		
		// Return user to Spring for processing.
		// Take note we're not the one evaluating whether this user is authenticated or valid
		// We just merely retrieve a user that matches the specified username
		return user;
	}
	
	/**
	 * Retrieves the correct ROLE type depending on the access level, where access level is an Integer.
	 * Basically, this interprets the access value whether it's for a regular user or admin.
	 * 
	 * @param access an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	 public Collection<GrantedAuthority> getAuthorities(Integer access) {
			// Create a list of grants for this user
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
			
			// All users are granted with ROLE_USER access
			// Therefore this user gets a ROLE_USER by default
			logger.debug("Grant ROLE_USER to this user");
			authList.add(new GrantedAuthorityImpl("ROLE_USER"));
			
			// Check if this user has admin access 
			// We interpret Integer(1) as an admin user
			//if ( access.compareTo(1) == 0) {
				// User has admin access
				logger.debug("Grant ROLE_ADMIN to this user");
				authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			//}

			// Return list of granted authorities
			return authList;
	  }
}
