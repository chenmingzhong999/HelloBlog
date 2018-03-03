package net.evercodig.helloblog.pojo;

public class UserVO {
    private Integer id;

    private String username;

    private String password;

    private Long inintime;

    private Long changetime;

    public UserVO(Integer id, String username, String password, Long inintime, Long changetime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.inintime = inintime;
        this.changetime = changetime;
    }

    public UserVO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getInintime() {
        return inintime;
    }

    public void setInintime(Long inintime) {
        this.inintime = inintime;
    }

    public Long getChangetime() {
        return changetime;
    }

    public void setChangetime(Long changetime) {
        this.changetime = changetime;
    }
}