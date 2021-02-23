package com.example.demo.dao;

import com.example.demo.model.Group;
import com.example.demo.model.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JournalJdbc {
    private final JdbcTemplate jdbcTemplate;

    public Journal get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM JOURNAL WHERE id = ?", this::mapJournal, id);
    }

    public JournalJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Journal mapJournal(ResultSet rs, int i) throws SQLException {
        Journal journal = new Journal(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("study_plan_id"),
                rs.getInt("in_time"),
                rs.getInt("count"),
                rs.getInt("mark_id")
        );

        return journal;
    }
}
