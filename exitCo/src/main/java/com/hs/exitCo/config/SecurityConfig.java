package com.hs.exitCo.config;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hs.exitCo.config.auth.PrincipalDetailService;



//밑 세개는 세트임.
//빈등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는것.
@Configuration // 빈등록 IOC 관리
@EnableWebSecurity // 시큐리티 필터 추가 = 스프링 시큐리티 활성퐈 되어있는데 설정을 해당파일에서 하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder( encodePWD() );
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.csrf().disable() // csrf토큰 비활성화
			.authorizeHttpRequests()
			.antMatchers("/","/auth/**","/js/**","/css/**","/image/**")
			.permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/auth/loginForm")
			.loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 jsp에서요청된 url을 가로채서 대신 로그인함.
			.defaultSuccessUrl("/"); //정상적으로 요청완료되면 해당 루트로감

	}
}
