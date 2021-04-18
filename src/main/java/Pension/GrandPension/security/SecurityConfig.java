package Pension.GrandPension.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//설정관련
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //db랑 연결해주는거
    @Autowired
    private UserDetailsService userDetailsService;

    //*넘겨준 encoder를 스프링이 관리
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }



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

    //customize하려고 만든거
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

         }
}
