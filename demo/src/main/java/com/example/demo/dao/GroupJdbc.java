package com.example.demo.dao;

import com.example.demo.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public List<Group> getAllGroup()
    {
        return jdbcTemplate.query("SELECT * FROM STUDY_GROUP", this::mapGroup);
    }

    public void createGroup(int id, String name)
    {
        jdbcTemplate.update("INSERT INTO STUDY_GROUP (ID, NAME) VALUES (?, ?)", id, name);
    }

    public void deleteGroup(int id)
    {
        jdbcTemplate.update("DELETE FROM STUDY_GROUP WHERE ID = ?", id);
    }

    public void updateGroup(int id, String value)
    {
        jdbcTemplate.update("UPDATE STUDY_GROUP SET NAME = ? Where ID = ?;", value, id);
    }

    private Group mapGroup(ResultSet rs, int i) throws SQLException {
        Group group = new Group(
                rs.getInt("id"),
                rs.getString("name")
        );

        return group;
    }
}
