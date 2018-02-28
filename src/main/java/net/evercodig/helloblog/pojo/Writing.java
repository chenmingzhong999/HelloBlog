package net.evercodig.helloblog.pojo;

public class Writing {
    private Integer id;
    
    private String heading;

    private String content;

    private String author;

    private Long inittime;

    private Long changetime;

    public Writing(Integer id, String heading, String content, String author, Long inittime, Long changetime) {
        this.id = id;
        this.heading = heading;
        this.content = content;
        this.author = author;
        this.inittime = inittime;
        this.changetime = changetime;
    }

    public Writing() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading == null ? null : heading.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Long getInittime() {
        return inittime;
    }

    public void setInittime(Long inittime) {
        this.inittime = inittime;
    }

    public Long getChangetime() {
        return changetime;
    }

    public void setChangetime(Long changetime) {
        this.changetime = changetime;
    }
}