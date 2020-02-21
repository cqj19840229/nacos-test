package com.wotrd.elasticsearch.model.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Data
@ToString
@Document(indexName = "index_book11", shards = 1, replicas = 0)
public class BookDO {

    @Id
    private Long id;

    /**
     * text：存储数据时候，会自动分词，并生成索引
     * keyword：存储数据时候，不会分词建立索引
     *
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word",store = true)
    private String name;

    @Field(index = false, type = FieldType.Text)
    private String description;

    private BigDecimal price;

    private String authorName;

    private Object data;

}
