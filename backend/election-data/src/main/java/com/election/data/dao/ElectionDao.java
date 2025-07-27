package com.election.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ElectionDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean checkIfCityExists(String city, String statename){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select count(*) from public.city where name = ? and state = ?", new Object[]{city.toUpperCase(), statename.toUpperCase()});
        return  ((Long)(list.get(0).get("count")))>0;
    }

    public void insertCity(String city, String statename){
        jdbcTemplate.update("insert into public.city(name, state) values (?, ?)", new Object[]{city.toUpperCase(), statename.toUpperCase()});
    }

    public boolean checkIfCandidateExists(String candidateName){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select count(*) from public.candidate where name = ?", new Object[]{candidateName.toUpperCase()});
        return  ((Long)(list.get(0).get("count")))>0;
    }

    public void insertCandidate(String name){
        jdbcTemplate.update("insert into public.candidate(name, age, gender, address ) values (?, ?, ?, ?)", new Object[]{name.toUpperCase(), 0, "", ""});
    }

    public void insertCandidate() {

    }
}
