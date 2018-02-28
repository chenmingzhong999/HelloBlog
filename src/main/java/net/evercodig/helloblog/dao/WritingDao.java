package net.evercodig.helloblog.dao;

import net.evercodig.helloblog.pojo.Writing;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WritingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Writing record);

    int insertSelective(Writing record);

    Writing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Writing record);

    int updateByPrimaryKey(Writing record);

    List<Writing> selectByAuthorAndHeading(Map findMap);

    int selectTotalCount();

    List<Writing> selectWritingPage(Map limitMap);
}