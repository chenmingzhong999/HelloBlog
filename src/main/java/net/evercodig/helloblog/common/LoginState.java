package net.evercodig.helloblog.common;

public enum LoginState {
    Success("登录成功"),
    Fail("登录失败"),
    Error("用户名错误");

    public String content;
    LoginState(String content){
        this.content = content;
    }
}
