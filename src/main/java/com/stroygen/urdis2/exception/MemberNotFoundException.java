package com.stroygen.urdis2.exception;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(Long memberId) {
        super(String.format("회원 %s를 찾을 수 없습니다.", memberId));
    }
}
