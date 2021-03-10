package com.itproger.repo;

import com.itproger.models.ArticleModel;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository <ArticleModel, Long> {

}
