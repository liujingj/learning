package com.ljj.malllearning.nosql.mongodb;

import com.ljj.malllearning.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author ljj
 * @date 2020/9/29
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {

    List<MemberReadHistory> findByMemberIdOrderById(Long memberId);
}
