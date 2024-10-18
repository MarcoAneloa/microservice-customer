package com.microservice.customer.infrastructure.database;

import com.microservice.customer.domain.model.Customer;
import com.microservice.customer.domain.repository.CustomerRepository;
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
                                rs.getString("address"),
                                rs.getString("phone"),
                                rs.getString("password"),
                                rs.getBoolean("state")
                        )
        );
    }

    @Override
    public int save(Customer customer) {
        return jdbcTemplate.update(
                "insert into customer (name,address,phone,password,state) values (?,?,?,?,?)",
                customer.getName(), customer.getAddress(), customer.getPhone(),customer.getPassword(), customer.getState());
    }

    @Override
    public int update(Customer customer) {
        return jdbcTemplate.update(
                "update customer set name = ?, address=?, phone=?, password=?, state=? where id = ?",
                customer.getName(), customer.getAddress(), customer.getPhone(),customer.getPassword(), customer.getState(), customer.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from customer where id = ?",
                id);
    }
}
