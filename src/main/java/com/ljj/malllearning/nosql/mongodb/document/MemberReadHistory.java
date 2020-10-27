package com.ljj.malllearning.nosql.mongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 用户商品浏览记录
 * @author ljj
 * @date 2020/9/29
 */
@Document
@Data
public class MemberReadHistory {
    @Id
    private Long id;
    @Indexed
    private Long memberId;
    private String memberNickName;
    @Indexed
    private Long productId;

}
