package com.wotrd.elasticsearch.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 学校组织视图(TViewOrgStruct)实体类
 *
 * @author wangkj
 * @since 2019-12-26 11:44:47
 */
@Document(indexName = "index-view-org-struct", shards = 3, replicas = 1)
@Data
public class ViewOrgStructDO implements Serializable {
    private static final long serialVersionUID = 489600357210986222L;

    @Id
    private String id;
    
    private Integer isDelete;
    
    private Date gmtCreate;
    
    private Date gmtModify;
    /**
     * 学校组织ID
     */
    private String orgId;
    /**
     * 规则id
     */
    private Integer ruleId;
    /**
     * 组织名称
     */
    private String name;
    /**
     * 父结点id
     */
    private String parentId;
    /**
     * 规则类型
     */
    private Integer ruleType;
    /**
     * 部门人数统计
     */
    private Integer total;
    /**
     * 排序(因为关键字冲突，已废弃)
     */
    private Integer order;
    /**
     * 排序
     */
    private Integer sortNum;


}