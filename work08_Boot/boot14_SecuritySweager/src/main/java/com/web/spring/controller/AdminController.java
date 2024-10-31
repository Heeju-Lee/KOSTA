package com.web.spring.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.domain.Member;
import com.web.spring.security.CustomMemberDetails;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AdminController {
    @GetMapping("/admin")
    public String admin(){
        //시큐리티에 저장된 정보 조회
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Authentication getName =  {} " , name);

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        CustomMemberDetails customMemberDetails =
                (CustomMemberDetails)authentication.getPrincipal();

        Member m = customMemberDetails.getMember();
        log.info("customMemberDetails =  {} ,{} ,{} " , m.getId(), m.getName(), m.getRole());


        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        while(iter.hasNext()){
            GrantedAuthority auth = iter.next();
            String role = auth.getAuthority();
            log.info("Authentication role =  {} " , role);
        }

        return "admin 입니다.";
    }
}
