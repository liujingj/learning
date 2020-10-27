package com.ljj.malllearning.nosql.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;

/**
 * @author ljj
 * @date 2020/9/29
 */
@Document(indexName = "", shards = 1, replicas = 1)
@Data
public class EsProduct implements Serializable {
    @Id
    private Long id;
    @Field(type = FieldType.Keyword)
    private String productSn;
    private Long brandId;
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Nested)
    private List<String> list;
}
