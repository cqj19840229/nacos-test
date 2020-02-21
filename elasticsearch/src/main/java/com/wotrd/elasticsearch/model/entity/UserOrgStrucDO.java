package com.wotrd.elasticsearch.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户部门岗位角色表(TUserOrgStruc)实体类
 *
 * @author wagnkj
 * @since 2019-12-26 11:43:50
 */
@Document(indexName = "index-user-org-struc", shards = 3, replicas = 1)
@Data
public class UserOrgStrucDO implements Serializable {
    private static final long serialVersionUID = 527363278316852002L;

    @Id
    private String id;
    /**
     * 企业ID
     */
    private String orgId;
    /**
     * 组织结构Id（部门，班级，年级）
     */
    private String orgStrucId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 角色ID
     */
    private String roleSign;
    /**
     * 角色扩展信息（老师有语文，数据。。。）
     */
    private String roleExtend;
    /**
     * 岗位角色在部门下的排序号
     */
    private Integer sortNum;
    /**
     * 进入时间
     */
    private Object inDate;
    /**
     * 离开时间
     */
    private Object outDate;
    /**
     * 离开原因说明
     */
    private String outReason;
    /**
     * 是否删除 1:删除；0：正常
     */
    private String isDelete;
    
    private Date gmtCreate;
    
    private Date gmtModify;
    
    private String modifyUser;
    /**
     * 操作版本
     */
    private Long operationVersion;
    
    private String createUser;


}