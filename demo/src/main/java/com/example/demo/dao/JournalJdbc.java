package com.example.demo.dao;

import com.example.demo.model.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JournalJdbc {
    private final JdbcTemplate jdbcTemplate;

    public JournalJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Journal get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM JOURNAL WHERE id = ?", this::mapJournal, id);
    }

    public List<Journal> getAll()
    {
        return jdbcTemplate.query("SELECT * FROM JOURNAL", this::mapJournal);
    }

    public List<Journal> getAllOnStudent(int id)
    {
        return jdbcTemplate.query("SELECT * FROM JOURNAL WHERE STUDENT_ID = ?", this::mapJournal, id);
    }

    public List<Journal> getAllOnGroup(int id)
    {
        return jdbcTemplate.query("SELECT * from JOURNAL J\n" +
                "inner join STUDENT S\n" +
                "ON J.STUDENT_ID=S.ID\n" +
                "WHERE S.STUDY_GROUP_ID = ?", this::mapJournal, id);
    }

    public void updateJournal(int id, int value)
    {
        jdbcTemplate.update("UPDATE JOURNAL SET MARK_ID = ? Where ID = ?;", value, id);
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
