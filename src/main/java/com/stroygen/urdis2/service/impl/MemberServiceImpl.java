package com.stroygen.urdis2.service.impl;

import com.stroygen.urdis2.dto.MemberDto;
import com.stroygen.urdis2.dto.member.MemberRegisterRequestDto;
import com.stroygen.urdis2.entity.Member;
import com.stroygen.urdis2.entity.Role;
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
    public Member registerMember(MemberRegisterRequestDto request) {
        String email = request.email();
        if (memberRepository.existsByEmail(email)) {
            throw new MemberAlreadyExistsException(email);
        }
        Member member = Member.builder()
                .email(request.email())
                .name(request.nickname())
                .birth(request.birth())
                .role(Role.ROLE_MEMBER)
                .build();
        return memberRepository.save(member);
    }

    @Override
    public void removeMember(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member member = optionalMember.orElseThrow(MemberNotFoundException::new);
        memberRepository.delete(member);
    }

    @Override
    public Member getMember(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member.orElseThrow(MemberNotFoundException::new);
    }

    @Override
    public MemberDto getMember(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        return optionalMember.map(MemberDto::new).orElseThrow(MemberNotFoundException::new);
    }

    @Override
    public boolean isExists(String email) {
        return memberRepository.existsByEmail(email);
    }
}
