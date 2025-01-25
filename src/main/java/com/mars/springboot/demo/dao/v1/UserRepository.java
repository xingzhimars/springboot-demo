package com.mars.springboot.demo.dao.v1;

import com.mars.springboot.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by geyan on 2025/1/25 14:01
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
