package com.ljj.malllearning.nosql.elasticsearch;

import com.ljj.malllearning.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 会继承一些基本操作
 *
 * @author ljj
 * @date 2020/9/29
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {

    //elasticsearch结合中文分词器插件 默认分词器是将中文逐个单词分割 中文分词器会按照语义进行分隔
    Page<EsProduct> findByIdAndName(Long id, String name);

    Page<EsProduct> findByIdOrName(Long id, String name);

    //复杂的查询 涉及过滤 不同字段匹配权重不同 排序
}
