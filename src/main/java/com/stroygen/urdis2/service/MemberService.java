package com.stroygen.urdis2.service;

import com.stroygen.urdis2.entity.Member;

public interface MemberService {
    Member createMember(Member member);
    void removeMember(Long memberId);
    Member getMember(Long memberId);
}
