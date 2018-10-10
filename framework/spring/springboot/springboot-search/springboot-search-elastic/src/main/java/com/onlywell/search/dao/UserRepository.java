/**
 * 
 */
package com.onlywell.search.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.onlywell.search.entity.User;

/**
 * @author harry
 */
@Component
public interface UserRepository extends ElasticsearchRepository<User, Long> {
	
	User queryUserById(Long id);
}
