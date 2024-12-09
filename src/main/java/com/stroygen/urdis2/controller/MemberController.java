package com.stroygen.urdis2.controller;

import com.stroygen.urdis2.dto.MemberDto;
import com.stroygen.urdis2.dto.member.MemberRegisterRequestDto;
import com.stroygen.urdis2.entity.Member;
import com.stroygen.urdis2.service.MemberService;
import com.stroygen.urdis2.service.authentication.TokenService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
public class MemberController {
    private final MemberService memberService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<Member> register(@RequestBody MemberRegisterRequestDto registerRequestDto, HttpServletResponse response) {
        Member member = memberService.registerMember(registerRequestDto);
        tokenService.issueJwt(new MemberDto(member), response);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> remove(@PathVariable("memberId") Long memberId) {
        if (memberId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request");
        }

        memberService.removeMember(memberId);
        return ResponseEntity.status(HttpStatus.OK).body("removed");
    }
}
