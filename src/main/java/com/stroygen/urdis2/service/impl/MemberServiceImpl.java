package com.stroygen.urdis2.service.impl;

import com.stroygen.urdis2.entity.Member;
import com.stroygen.urdis2.exception.MemberAlreadyExistsException;
import com.stroygen.urdis2.exception.MemberNotFoundException;
import com.stroygen.urdis2.repository.MemberRepository;
import com.stroygen.urdis2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    @Override
    public Member createMember(Member member) {
        String email = member.getEmail();
        if (memberRepository.existsByEmail(email)) {
            throw new MemberAlreadyExistsException(email);
        }
        return memberRepository.save(member);
    }

    @Override
    public void removeMember(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member member = optionalMember.orElseThrow(() -> new MemberNotFoundException(memberId));
        memberRepository.delete(member);
    }

    @Override
    public Member getMember(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member.orElseThrow(() -> new MemberNotFoundException(memberId));
    }
}
