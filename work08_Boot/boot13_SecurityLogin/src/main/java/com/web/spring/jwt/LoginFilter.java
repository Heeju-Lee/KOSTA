package com.web.spring.jwt;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.google.gson.Gson;
import com.web.spring.domain.Member;
import com.web.spring.security.CustomMemberDetails;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginFilter extends UsernamePasswordAuthenticationFilter{ //폼값 받는 컨트롤러 역할의 필터
	
	private final AuthenticationManager authenticationManager;
	
	private final JWTUtil jwtUtil;

	public LoginFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) 
																		throws AuthenticationException{
		
		//1. 클라이언트 로그인 요청시 id, password 받아서 출력
		String username=super.obtainUsername(request); //id
		String password = super.obtainPassword(request);// password
		
		log.info("username{}",username);
		log.info("password{}",password);
		
		//2. 스프링 시큐리티에서는 username, password를 검증하기 위해서 ~~~~~token에 담는다.
		//지금은 authorization은 없어서 null로 담았다.
		UsernamePasswordAuthenticationToken authToken = 
				new UsernamePasswordAuthenticationToken(username, password, null);
		
		//3. token을 ~~~Manager에 전달 ... Provider....DetailsService....db연결...CustomMemberDetails생성....back -> back
		// 리턴하는 정보는 CustomMemberDetails 이지만 authenticationToken으로 만들어줌.
		Authentication authentication =authenticationManager.authenticate(authToken);//CustomMemberDetails 정보를 반환...
		log.info("authentication{}",authentication);

		return authentication;
	}
	
	//로그인 성공시 실행하는 메소드 (여기서 JWT를 발급하면 됨)
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) throws  IOException{
        response.setContentType("text/html;charset=UTF-8");
       log.info("로그인 성공 ......");
        //UserDetailsS
        CustomMemberDetails customMemberDetails = (CustomMemberDetails) authentication.getPrincipal();
        //이 정보는 왜 받아왔을까?
        String username = customMemberDetails.getUsername();//아이디
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority(); //ROLE_USER or ROLE_ADMIN
        //토큰생성과정...이때 password는 JWTUtil에서 안담았다.
        String token = jwtUtil.createJwt(
                customMemberDetails.getMember(), role, 1000L*60*10L);//1초*60*10 10분
        System.out.println("@@@@@@@@@@@@@@@@@@ getMember "+ customMemberDetails.getMember() +" @@@@@@@@@@@@@@@@@@");
        //응답할 헤더를 설정
        //베어러 뒤에 공백을 준다. 관례적인  prefix
        response.addHeader("Authorization", "Bearer " + token);
        Map<String, Object> map = new HashMap<>();
        Member   member= customMemberDetails.getMember();
        map.put("memberNo",member.getMemberNo() );
        map.put("id", member.getId());
        map.put("name", member.getName());
        map.put("address", member.getAddress());
        Gson gson= new Gson();
        String arr = gson.toJson(map);
        response.getWriter().print(arr);
    }
    
    
    //로그인 실패시 실행하는 메소드
    //CustomMemberDetailsService에서 null이 떨어지면 이곳으로 리턴..
    //응답 메세지를 Json형태로 프론크 단으로 넘기기 위해서 Gson 라이브러리 사용함.
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        log.info("로그인 실패... ......");
        //로그인 실패시 401 응답 코드 반환
        response.setStatus(401);
        Map<String, Object> map = new HashMap<>();
        map.put("errMsg","정보를 다시 확인해주세요.");
        Gson gson= new Gson();
        String arr = gson.toJson(map);
        response.getWriter().print(arr);
    }
}
