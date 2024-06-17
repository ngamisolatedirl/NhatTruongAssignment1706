package assignment1706.nhattruong.jpaRepository.main.impl;

import assignment1706.nhattruong.jpaRepository.annotation.Entity;
import assignment1706.nhattruong.jpaRepository.consts.SqlQueryConstants;
import assignment1706.nhattruong.jpaRepository.main.JpaExecutor;
import assignment1706.nhattruong.utils.ConnectionPool;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class JpaExecutorImpl<T> implements JpaExecutor<T> {
    private Class<T> clazz;
    private String className;
    public String tableName;
    Field[] fields;

    public static void main(String[] args) {

    }

    public JpaExecutorImpl(Class<T> clazz) {
        this.clazz = clazz;
        this.className = clazz.getSimpleName();
        // get mapping of tableName
        this.tableName = clazz.getAnnotation(Entity.class) != null ?
                clazz.getAnnotation(Entity.class).tableName()
                : className;
        this.fields = clazz.getDeclaredFields();
        System.err.println(this.className);
        System.err.println(this.tableName);
        System.err.println(this.fields);
    }

    public abstract List<T> rowMapper(ResultSet rs);


    @Override
    public List<T> findAll() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        String sql = SqlQueryConstants.SQL_SELECT_ALL.replace("%table_name%", this.tableName);
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            return rowMapper(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void add(T entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        String sql = SqlQueryConstants.SQL_INSERT.replace("%table_name%", this.tableName);
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
            mapToPreparedStatement(pt, entity);
            pt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected abstract void mapToPreparedStatement(PreparedStatement pt, T entity) throws SQLException;

}