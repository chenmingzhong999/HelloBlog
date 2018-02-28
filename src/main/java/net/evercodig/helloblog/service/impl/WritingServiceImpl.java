package net.evercodig.helloblog.service.impl;

import net.evercodig.helloblog.dao.WritingDao;
import net.evercodig.helloblog.pojo.PageBean;
import net.evercodig.helloblog.pojo.Writing;
import net.evercodig.helloblog.pojo.WritingVO;
import net.evercodig.helloblog.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WritingServiceImpl implements WritingService {

    @Autowired
    WritingDao writingDao;

    @Override
    public Writing selectWritingById(int id) {
        Writing writing = writingDao.selectByPrimaryKey(id);
        return writing;
    }

    @Override
    public List<Writing> selectWritingByAuthorAndHeading(String heading, String author) {
        Map<String, String> findMap = new HashMap<String, String>();
        findMap.put("author", author);
        findMap.put("heading", heading);
        System.out.println(findMap);
        List<Writing> writings = writingDao.selectByAuthorAndHeading(findMap);
        return writings;
    }

    @Override
    public void insertWriting(WritingVO writingVO) {
        Writing writing = new Writing();
        writing.setHeading(writingVO.getHeading());
        writing.setContent(writingVO.getContent());
        writing.setAuthor(writingVO.getAuthor());
        writing.setInittime(System.currentTimeMillis());
        writing.setChangetime(System.currentTimeMillis());

        int i = writingDao.insert(writing);
        System.out.println(i);
    }

    @Override
    public void updateWriting(Integer id, WritingVO writingVO) {
        Writing writing = new Writing();
        writing.setId(id);
        writing.setHeading(writingVO.getHeading());
        writing.setContent(writingVO.getContent());
        writing.setAuthor(writingVO.getAuthor());
        writing.setChangetime(System.currentTimeMillis());
        int i = writingDao.updateByPrimaryKeySelective(writing);
        System.out.println(i);
    }

    @Override
    public PageBean<Writing> findPage(int page, int limit) {
        //查询总记录数
        int totalCount = writingDao.selectTotalCount();
        //计算总页数
        int totalPage;
        if (totalCount % limit == 0) {
            totalPage = totalCount / limit;
        } else {
            totalPage = (totalCount / limit) + 1;
        }
        //计算 从第几条开始
        int begin = (page - 1) * limit;
        //查询记录
        final HashMap<String, Integer> limitMap = new HashMap<String, Integer>();
        limitMap.put("begin", begin);
        limitMap.put("limit", limit);
        List<Writing> writings = writingDao.selectWritingPage(limitMap);
        //封装分页实体
        PageBean<Writing> writingPageBean = new PageBean<>();
        writingPageBean.setLimit(limit);
        writingPageBean.setPage(page);
        writingPageBean.setTotalCount(totalCount);
        writingPageBean.setTotalPage(totalPage);
        writingPageBean.setList(writings);

        return writingPageBean;
    }


}
