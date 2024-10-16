package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	//인증관련 설정은 ...SecurityFilterChain
	//SecurityFilterChain을 빈으로 지정..여기다가 인증관련된 인가정책을 등록
	//members/...로 접근했을 때 인증여부
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		//여기다가 http 요청에 대한 인증과 권한관련 정책을 등록...7버전 부터는 모든 코드를 람다형싱으로 작성하도록 규정돼 있다.
		http
			.authorizeHttpRequests(auth->auth.anyRequest().authenticated())//어떤 요청에도 인증을 받겠다.
			.formLogin(Customizer.withDefaults());//디폴드 방식인 로그인 폼으로 인증을 받겠다.
		
		return http.build();
	}
	
	//UserDetailsService빈을 등록하고...디비 연결햇다 치고...id, password 정보를 InMemory
	//properties 설정파일에도 user정보를 등록했다.... 이럴때 뭐가 더 우선 순위일까?
	//bean 설정이 우선 순위가 높다.
	//User 정보는 id, password, role 임.
	@Bean
	public UserDetailsService userDetailsService() throws Exception{
		UserDetails user = User.withUsername("security")
							   .password("{noop}7777")
							   .roles("USER").build();
		
		UserDetails user1 = User.withUsername("security1")
				   .password("{noop}7777")
				   .roles("USER").build();
		
		UserDetails user2 = User.withUsername("security2")
				   .password("{noop}7777")
				   .roles("USER").build();
		
		
		return new InMemoryUserDetailsManager(user, user1, user2);
	}
	
	
}
