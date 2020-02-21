package com.wotrd.elasticsearch.dao;

import com.wotrd.elasticsearch.model.entity.BookDO;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ElasticsearchRepository<BookDO, Long> {

    @Query("")
    List<BookDO> findBookDOByAuthorNameAndAndPriceBetween(String name, Integer price);

}
