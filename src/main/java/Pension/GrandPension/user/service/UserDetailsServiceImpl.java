package Pension.GrandPension.user.service;


import Pension.GrandPension.user.dto.User;
import Pension.GrandPension.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.findByUserName(s);

        if (user !=null)
        {
            return user;
        }
        throw new UsernameNotFoundException("User" + s + "not found ");
    }

}
