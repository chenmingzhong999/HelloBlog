package net.evercodig.helloblog.service.impl;

import net.evercodig.helloblog.dao.WritingDao;
import net.evercodig.helloblog.pojo.PageBean;
import net.evercodig.helloblog.pojo.Writing;
import net.evercodig.helloblog.pojo.WritingVO;
import net.evercodig.helloblog.service.WritingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WritingServiceImpl implements WritingService {
    public static final Logger logger = LoggerFactory.getLogger(WritingServiceImpl.class);

    @Autowired
    WritingDao writingDao;

    @Override
    public Writing selectWritingById(int id) {
        Writing writing = writingDao.selectByPrimaryKey(id);
        logger.info("根据id查询记录", writing);
        return writing;
    }

    @Override
    public List<Writing> selectWritingByAuthorAndHeading(String heading, String author) {
        Map<String, String> findMap = new HashMap<String, String>();
        findMap.put("author", author);
        findMap.put("heading", heading);
        System.out.println(findMap);
        List<Writing> writings = writingDao.selectByAuthorAndHeading(findMap);
        logger.info("根据作者标题查询记录{}",writings);
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
        logger.info("文章保存{}", i);
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
        logger.info("文章更新{}",i);
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
        List<Writing> writings = writingDao.selectWritingPage(begin, limit);
        //封装分页实体
        PageBean<Writing> writingPageBean = new PageBean<>();
        writingPageBean.setLimit(limit);
        writingPageBean.setPage(page);
        writingPageBean.setTotalCount(totalCount);
        writingPageBean.setTotalPage(totalPage);
        writingPageBean.setList(writings);
        logger.info("分页查询实体{}", writingPageBean);
        return writingPageBean;
    }
}
