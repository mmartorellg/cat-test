package com.cat.test.infrastructure.db.generic;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class GenericAdapter {

    private final NamedParameterJdbcTemplate template;

    public <T> List<T> queryForList(String sql, Map<String, Object> params, Class<T> clazz) {
        return template.query(sql, params, new BeanPropertyRowMapper<>(clazz));
    }

    public GenericAdapter(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public <T> Optional<T> getOne(String sql, Map<String, Object> params, Class<T> clazz) {
        return getQuery(sql, params, clazz).stream().findFirst();
    }

    public <T> List<T> getAll(String sql, Class<T> clazz) {
        HashMap<String, Object> params = new HashMap<>();
        return getQuery(sql, params, clazz);
    }

    private <T> List<T> getQuery(String sql, Map<String, Object> params, Class<T> clazz) {
        return template.query(sql, params, new BeanPropertyRowMapper<>(clazz));
    }

    public Integer save(String sql, MapSqlParameterSource params) {
        return template.update(sql, params);
    }

    public Integer update(String sql, MapSqlParameterSource params) {
        return template.update(sql, params);
    }

    public boolean delete(String sql, MapSqlParameterSource params) {
        return template.update(sql, params) == 1;
    }
}
