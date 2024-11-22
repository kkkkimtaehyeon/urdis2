package com.stroygen.urdis2.exception;

public class MemberAlreadyExistsException extends RuntimeException{
    public MemberAlreadyExistsException(String email) {
        super(String.format("%s로 가입된 회원이 존재합니다.", email));
    }
}
