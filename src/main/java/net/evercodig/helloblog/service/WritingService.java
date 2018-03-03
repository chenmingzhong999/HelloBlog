package net.evercodig.helloblog.service;

import net.evercodig.helloblog.pojo.PageBean;
import net.evercodig.helloblog.pojo.Writing;
import net.evercodig.helloblog.pojo.WritingVO;
import java.util.List;

public interface WritingService {
    Writing selectWritingById(int id);

    List<Writing> selectWritingByAuthorAndHeading(String heading, String author);

    void insertWriting(WritingVO writingVO);

    void updateWriting(Integer id, WritingVO writingVO);

    PageBean<Writing> findPage(int page, int limit);
}
