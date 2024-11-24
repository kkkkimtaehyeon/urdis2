package com.stroygen.urdis2.service;

import com.stroygen.urdis2.dto.member.MemberRegisterRequestDto;
import com.stroygen.urdis2.entity.Member;

public interface MemberService {
    Member registerMember(MemberRegisterRequestDto requestDto);
    void removeMember(Long memberId);
    Member getMember(Long memberId);
    boolean isExists(String email);
}
