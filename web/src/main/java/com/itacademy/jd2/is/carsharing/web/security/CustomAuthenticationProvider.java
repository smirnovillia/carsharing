package com.itacademy.jd2.is.carsharing.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final IUserAccountService userAccountService;

	@Autowired
	public CustomAuthenticationProvider(IUserAccountService userAccountService) {
		super();
		this.userAccountService = userAccountService;
	}

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		final String username = authentication.getPrincipal() + "";
		final String password = authentication.getCredentials() + "";

		final IUserAccount userAccount = userAccountService.getByLogin(username);

		if (userAccount == null) {
			throw new BadCredentialsException("no such user");
		}

		if (!userAccount.getLogin().equals(username)) {
			throw new BadCredentialsException("1000");
		}

		// TODO verify password (DB contains hasn - not a plain password)

		if (!userAccount.getPassword().equals(password)) {
			throw new BadCredentialsException("1000");
		}

		final int userId = userAccount.getId(); // FIXME: it should be the real user id from DB

		final List<String> userRoles = new ArrayList<>();// TODO get list of user's
		// roles

		String role = userAccount.getUserRole().name();
		userRoles.add("ROLE_" + role);

		final List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (final String roleName : userRoles) {
			authorities.add(new SimpleGrantedAuthority(roleName));
		}
		return new ExtendedUsernamePasswordAuthenticationToken(userId, username, password, authorities);

	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
