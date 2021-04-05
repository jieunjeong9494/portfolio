package Pension.GrandPension.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//설정관련
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //요청 (받는 상태에 따라 달라야함)
        http.authorizeRequests()
                //설정 세분화되어있는 조건이 항상 위에 옴
                .antMatchers("/board/list").access("hasRole('ROLE_USER')")
                .antMatchers("/","/**").access("permitAll")
                //로그인 팝업
                .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //메모리상에 강제로 쓰는거
        auth.inMemoryAuthentication()
                .withUser("user1").password("password1").authorities("ROLE_USER")
                .and().withUser("USER2").password("{noop}password2").authorities("ROLE_USER");
    }


}
