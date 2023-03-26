package com.sandi.spring_transactional.repository;

import com.sandi.spring_transactional.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveProductDao(Product product){
        String sql = "insert into product values(?, ?)";
        Object[] args = {product.getId(), product.getName()};
        jdbcTemplate.update(sql, args);
    }

}
