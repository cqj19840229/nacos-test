package com.wotrd.elasticsearch.dao;

import com.wotrd.elasticsearch.model.entity.UserDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表(TUser)表数据库访问层
 *
 * @author wotrd
 * @since 2019-12-26 20:56:26
 */
@Repository
public interface UserRepository extends ElasticsearchCrudRepository<UserDO, String> {

    List<UserDO> findByUserName(String name);

    List<UserDO> findByUserNameInAndAndIdIn(String name, String id);
}