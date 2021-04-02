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

    public void updateStudent(Student value)
    {
        jdbcTemplate.update("UPDATE STUDENT SET SURNAME = ?, NAME = ?, SECOND_NAME = ?, STUDY_GROUP_ID = ? Where ID = ?;", value.getSurname(), value.getName(), value.getSecond_name(), value.getStudy_group_id(), value.getId());
    }

    public void updateStudentById(int ids, int idg)
    {
        jdbcTemplate.update("UPDATE STUDENT SET STUDY_GROUP_ID = ? Where ID = ?;", idg, ids);
    }

    public List<Student> getAllOnGroupSorted(int study_group_id)
    {
        return jdbcTemplate.query("SELECT * FROM STUDENT WHERE STUDY_GROUP_ID = ? order by SURNAME", this::mapStudent, study_group_id);
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