package com.example.login.configuration;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if("hoge".equals(username)) {
            return new User(username, "HOGE", AuthorityUtils.createAuthorityList("USER"));
        }
        throw new UsernameNotFoundException("not found" + username);
    }
}
