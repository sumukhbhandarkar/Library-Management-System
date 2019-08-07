package com.sumukh.librarymanagementsystem.repo;

import com.sumukh.librarymanagementsystem.entity.BookEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepo extends ElasticsearchRepository<BookEntity, String> {

}
