package com.stroygen.urdis2.exception;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException() {
        super("존재하지 않는 회원입니다.");
    }
}
