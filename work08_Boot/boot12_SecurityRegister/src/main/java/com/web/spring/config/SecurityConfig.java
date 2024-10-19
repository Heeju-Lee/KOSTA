package com.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//인증방식과 인가 정책을 지정....
		log.info("SecurityFilterChain call.. ===================================>");
		
		http.csrf((auth)->auth.disable()); //csrf 공격을 방어하기 위해 비활성화.(추후 공부를 해보길)
		http.formLogin((auth)->auth.disable());
		http.httpBasic((auth)->auth.disable());
		
		//경로별 인가 작업
		http.authorizeHttpRequests((auth)->auth
					.requestMatchers("/index","/members","/members/**","/boards").permitAll()//"**" 
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated()//인증을 거쳐서 들어와야 한다.
				);		
		
		return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		log.info("BCryptPasswordEncoder call ...===================================>");
		return new BCryptPasswordEncoder();
	}
}
