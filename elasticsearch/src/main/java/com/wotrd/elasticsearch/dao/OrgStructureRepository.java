package com.wotrd.elasticsearch.dao;

import com.wotrd.elasticsearch.model.entity.OrgStructureDO;
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
public interface OrgStructureRepository extends ElasticsearchCrudRepository<OrgStructureDO, String> {

    /**
     * 根据父ID查找部门
     *
//     * @param orgId
//     * @param parentId
//     * @param isDeleted
     * @return
     */
    OrgStructureDO findOrgStructureDOById(String id);

//    List<OrgStructureDO> findByOrgIdAndParentIdAndIsDelete(String orgId, String parentId, String isDeleted);

    /**
     * 根据父ID查找部门
     *
     * @param orgId
     * @param isDeleted
     * @return
     */
    List<OrgStructureDO> findByOrgIdAndIsDelete(String orgId, String isDeleted);
}