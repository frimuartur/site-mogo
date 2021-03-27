package com.itproger.repo;

import com.itproger.models.ArticleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface ArticleRepository extends CrudRepository <ArticleModel, Long> {

    Collection <ArticleModel> findByUserId(Long userId);

}
