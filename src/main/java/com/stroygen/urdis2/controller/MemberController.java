package com.stroygen.urdis2.controller;

import com.stroygen.urdis2.dto.member.MemberRegisterRequestDto;
import com.stroygen.urdis2.entity.Member;
import com.stroygen.urdis2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> register(@ModelAttribute MemberRegisterRequestDto registerRequestDto) {
        Member member = memberService.registerMember(registerRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }
}
