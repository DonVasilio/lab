package com.example.demo.dao;

import com.example.demo.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class GroupJdbc {
    private final JdbcTemplate jdbcTemplate;

    public GroupJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Group get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM STUDY_GROUP WHERE id = ?", this::mapGroup, id);
    }

    private Group mapGroup(ResultSet rs, int i) throws SQLException {
        Group group = new Group(
                rs.getInt("id"),
                rs.getString("name")
        );

        return group;
    }
}
