package com.wotrd.elasticsearch.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业组织 内部门结构表(TOrgStructure)实体类
 *
 * @author wangkj
 * @since 2019-12-26 11:44:17
 */
@Document(indexName = "index_org_structure")
@Data
public class OrgStructureDO implements Serializable {
    private static final long serialVersionUID = -73827851278649765L;

    private String id;
    /**
     * 企业ID
     */
    private String orgId;
    /**
     * 短ID，用于校内识别部门
     */
    private Integer shortId;
    /**
     * 父节点ID(如果是一级组织则为0)
     */
    private String parentId;
    /**
     * 组织结构实体类型, 必须与父实体节点一致
     */
    private String strucEntitySign;
    /**
     * 组织类型ID
     */
    private String managementEntitySign;
    /**
     * 组织类型名称（学校，系。班，虚拟节点：0）
     */
    private String managementEntityName;
    /**
     * 组织名称
     */
    private String strucName;
    /**
     * 组织机构描述
     */
    private String strucDesc;
    /**
     * 排序号
     */
    private Integer sortNum;
    /**
     * 标签，（如果是年级，班级，可用来计算几年级）
     */
    private String strucTag;
    /**
     * 是否删除 1:删除；0：正常
     */
    private String isDelete;
    
    private String createUser;
    
    private Date gmtCreate;
    
    private String modifyUser;
    
    private Date gmtModify;
    /**
     * 同步序号，同步时专用
     */
    private Integer syncIndex;
    /**
     * 操作版本
     */
    private Long operationVersion;

}