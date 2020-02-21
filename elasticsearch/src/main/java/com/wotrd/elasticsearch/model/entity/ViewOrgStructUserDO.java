package com.wotrd.elasticsearch.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 学校视图组织用户表(TViewOrgStructUser)实体类
 *
 * @author wangkj
 * @since 2019-12-26 13:12:40
 */
@Document(indexName = "index-view-org-struct-user", shards = 3, replicas = 1)
@Data
public class ViewOrgStructUserDO implements Serializable {
    private static final long serialVersionUID = 767979684289431203L;

    @Id
    private Long id;
    
    private Integer isDelete;
    
    private Date gmtCreate;
    
    private Date gmtModify;
    /**
     * 学校组织id
     */
    private String orgId;
    /**
     * 视图部门id
     */
    private String structId;
    /**
     * 用户id
     */
    private String userId;


}