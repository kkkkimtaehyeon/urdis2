package com.stroygen.urdis2.dto;

import com.stroygen.urdis2.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private long id;
    private String email;
    private String role;

    public MemberDto( String email, String role){
        this.email = email;
        this.role = role;
    }

    public MemberDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.role = member.getRole().name();
    }
}
