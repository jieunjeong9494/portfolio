package Pension.GrandPension.user.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Data
public class User implements UserDetails {


    private static final long serialVersionUID = 2993777325929086162L;

    //db id
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String phoneNumber;

    public User(String username, String password,String fullname , String phoneNumber ){

        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    //리턴하면 계정이 만료되지 않음
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //리턴하면 계정이 잠기지 않음
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //비밀번호가 만료되지 않음
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 활성화되면 리턴
    @Override
    public boolean isEnabled() {
        return true;
    }
}
