package com.wotrd.kafkatemplate.mapper;

import com.wotrd.kafkatemplate.domain.QuestionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * (QuestionDO)表数据库访问层
 *
 * @author wotrd
 * @since 2019-05-26 00:12:53
 */
@Repository
@Mapper
public interface QuesttionMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    QuestionDO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<QuestionDO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<QuestionDO> queryAll();

    /**
     * 新增数据
     *
     * @param QuestionDO 实例对象
     * @return 影响行数
     */
    int insert(QuestionDO QuestionDO);

    /**
     * 修改数据
     *
     * @param QuestionDO 实例对象
     * @return 影响行数
     */
    int update(QuestionDO QuestionDO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}