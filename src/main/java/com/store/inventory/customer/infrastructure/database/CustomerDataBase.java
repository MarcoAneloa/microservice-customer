package com.store.inventory.customer.infrastructure.database;

import com.store.inventory.customer.domain.model.Customer;
import com.store.inventory.customer.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDataBase implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query(
                "select * from customer",
                (rs, rowNum) ->
                        new Customer(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("document"),
                                rs.getString("image")
                        )
        );
    }

    @Override
    public int save(Customer customer) {
        return jdbcTemplate.update(
                "insert into customer (name, document,image) values(?,?,?)",
                customer.getName(), customer.getDocument(), customer.getImage());
    }

    @Override
    public int update(Customer customer) {
        return jdbcTemplate.update(
                "update customer set name = ?, document=?, image=? where id = ?",
                customer.getName(), customer.getDocument(), customer.getImage(), customer.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from customer where id = ?",
                id);
    }
}
