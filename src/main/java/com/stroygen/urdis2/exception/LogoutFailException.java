package com.stroygen.urdis2.exception;

public class LogoutFailException extends RuntimeException {
  public LogoutFailException() {
    super("로그아웃 처리 중 에러가 문제가 발생했습니다.");
  }
}
