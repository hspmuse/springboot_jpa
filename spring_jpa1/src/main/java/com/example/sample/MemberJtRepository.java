package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberJtRepository {

    @Autowired
    NamedParameterJdbcTemplate jt;

    public List<MemberDomain> findByName(String name) {

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", name);

        return jt.query(MemberSql.SELECT_MEMBER_FIND_NAME, param, new BeanPropertyRowMapper<>(MemberDomain.class));
    }
}
