package com.example.demo.dao;

import com.example.demo.model.SubjectType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SubjectTypeJdbc {
    private final JdbcTemplate jdbcTemplate;

    public SubjectTypeJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SubjectType> get()
    {
        return jdbcTemplate.query("select S.NAME, ET.TYPE from STUDY_PLAN\n" +
                "                inner join EXAM_TYPE ET on ET.ID = STUDY_PLAN.EXAM_TYPE_ID\n" +
                "                inner join SUBJECT S on S.ID = STUDY_PLAN.SUBJECT_ID;", this::mapSubjectType);
    }

    private SubjectType mapSubjectType(ResultSet rs, int i) throws SQLException {
        SubjectType student = new SubjectType(
                rs.getString("NAME"),
                rs.getString("TYPE")
        );

        return student;
    }
}
