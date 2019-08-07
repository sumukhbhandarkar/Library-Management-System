package com.sumukh.librarymanagementsystem.repo;

import com.sumukh.librarymanagementsystem.entity.IssuerEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IssuerRepo extends ElasticsearchRepository<IssuerEntity, String> {
}
