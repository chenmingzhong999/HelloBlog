package net.evercodig.helloblog.common;

public enum UserState {
    Success("成功"),
    Fail("失败");

    public String content;
    UserState (String content){
        this.content = content;
    }
}
