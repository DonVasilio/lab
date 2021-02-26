package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJdbc {
    private final JdbcTemplate jdbcTemplate;

    public StudentJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student get(int id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE id = ?", this::mapStudent, id);
    }

    public List<Student> getAll()
    {
        return jdbcTemplate.query("SELECT * FROM STUDENT", this::mapStudent);
    }

    public List<Student> getAllOnGroup(int study_group_id)
    {
        return jdbcTemplate.query("SELECT * FROM STUDENT WHERE STUDY_GROUP_ID = ?", this::mapStudent, study_group_id);
    }

    public void createStudent(int id, String surname, String name, String second_name, int study_group_id)
    {
        jdbcTemplate.update("INSERT INTO STUDENT (ID, SURNAME, NAME, SECOND_NAME, STUDY_GROUP_ID) VALUES (?, ?, ?, ?, ?)", id, surname, name, second_name, study_group_id);
    }

    public void deleteStudent(int id)
    {
        jdbcTemplate.update("DELETE FROM STUDENT WHERE ID = ?", id);
    }

    public void updateStudent(int id, String option, String value)
    {
        switch (option){
            case "surname":
                jdbcTemplate.update("UPDATE STUDENT SET SURNAME = ? Where ID = ?;", value, id);
                break;
            case "name":
                jdbcTemplate.update("UPDATE STUDENT SET NAME = ? Where ID = ?;", value, id);
                break;
            case "second_name":
                jdbcTemplate.update("UPDATE STUDENT SET SECOND_NAME = ? Where ID = ?;", value, id);
                break;
            case "study_group":
                jdbcTemplate.update("UPDATE STUDENT SET STUDY_GROUP_ID = ? Where ID = ?;", value, id);
                break;
        }
    }

    private Student mapStudent(ResultSet rs, int i) throws SQLException {
        Student student = new Student(
                rs.getInt("id"),
                rs.getString("surname"),
                rs.getString("name"),
                rs.getString("second_name"),
                rs.getInt("study_group_id")
        );

        return student;
    }
}