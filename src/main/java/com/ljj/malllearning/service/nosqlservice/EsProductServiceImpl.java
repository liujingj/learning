package com.ljj.malllearning.service.nosqlservice;

import com.ljj.malllearning.nosql.elasticsearch.EsProductRepository;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljj
 * @date 2020/10/15
 */
@Component
public class EsProductServiceImpl {
    @Resource
    private EsProductRepository esProductRepository;

    public Object search(String keyWord, Long brandId, Long productCategoryId, int pageNum, int pageSize, int sort) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withPageable(pageable);
        //过滤出去的 不需要查询出来的 比如当前商品
        if (brandId != null || productCategoryId != null) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            if (brandId != null) {
                boolQueryBuilder.must(QueryBuilders.termQuery("brandId", brandId));
            }
            if (productCategoryId != null) {
                boolQueryBuilder.must(QueryBuilders.termQuery("productCategoryId", productCategoryId));
            }
            builder.withFilter(boolQueryBuilder);
        }
        //搜索 根据不同权重
        if (StringUtils.isEmpty(keyWord)) {
            builder.withQuery(QueryBuilders.matchAllQuery());
        }else {
            List<FunctionScoreQueryBuilder.FilterFunctionBuilder> list=new ArrayList<>();
            list.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("name",keyWord), ScoreFunctionBuilders.weightFactorFunction(10)));
            list.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("subTitle",keyWord), ScoreFunctionBuilders.weightFactorFunction(5)));
            list.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("keywords",keyWord), ScoreFunctionBuilders.weightFactorFunction(2)));
            FunctionScoreQueryBuilder functionScoreQueryBuilder=QueryBuilders.functionScoreQuery(list.toArray(new FunctionScoreQueryBuilder.FilterFunctionBuilder[list.size()]))
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM).setMinScore(2);
            builder.withQuery(functionScoreQueryBuilder);
        }
        //根据不同字段排序
        if(sort==1){
            builder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
        }else if(sort==2){
            builder.withSort(SortBuilders.fieldSort("sale").order(SortOrder.DESC));
        } else if(sort==3){
            builder.withSort(SortBuilders.fieldSort("price").order(SortOrder.ASC));
        }else if(sort==4){
            builder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        }else{
            //相关度排序
            builder.withSort(SortBuilders.scoreSort().order(SortOrder.DESC));
        }
        NativeSearchQuery nativeSearchQuery=builder.build();
        return esProductRepository.search(nativeSearchQuery);
    }
}
