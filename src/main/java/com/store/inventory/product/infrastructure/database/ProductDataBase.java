package com.store.inventory.product.infrastructure.database;

import com.store.inventory.customer.domain.model.Customer;
import com.store.inventory.product.domain.model.Product;
import com.store.inventory.product.domain.model.request.ProductDTO;
import com.store.inventory.product.domain.repository.ProductDataBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDataBase implements ProductDataBaseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(
                "select * from product",
                (rs, rowNum) ->
                        new Product(
                                rs.getInt("id"),
                                rs.getString("cod"),
                                rs.getString("name"),
                                rs.getDouble("price"),
                                rs.getInt("stock")
                        )
        );
    }

    @Override
    public int save(Product product) {
        return jdbcTemplate.update(
                "insert into product (cod, name,price,stock) values(?,?,?,?)",
                product.getCod(), product.getName(), product.getPrice(), product.getStock());

    }

    @Override
    public int update(ProductDTO product) {
        return jdbcTemplate.update(
                "update product set stock=? where cod = ?",
                product.getStock(),product.getCod());

    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from product where id = ?",
                id);
    }
}
