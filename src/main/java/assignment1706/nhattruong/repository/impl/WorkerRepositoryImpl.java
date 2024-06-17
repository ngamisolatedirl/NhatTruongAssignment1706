package assignment1706.nhattruong.repository.impl;

import assignment1706.nhattruong.entity.Worker;
import assignment1706.nhattruong.repository.WorkerRepository;
import assignment1706.nhattruong.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WorkerRepositoryImpl implements WorkerRepository {
private static final String SQL_ADD_1WORKER = "INSERT INTO %table_name%(id,fullname,birthday,address,position,department) VALUES (?,?,?,?,?,?)";


    @Override
    public void addWorker(Worker worker) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try (Connection con = connectionPool.getConnection();
             PreparedStatement pt = con.prepareStatement(SQL_ADD_1WORKER)) {

            pt.setLong(1, worker.getId());
            pt.setString(2, worker.getFullname());
            pt.setString(3, worker.getBirthday());
            pt.setString(4, worker.getAddress());
            pt.setString(5, worker.getPosition());
            pt.setString(6, worker.getDepartment());

            pt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding student: " + worker, e);
        }
    }



    @Override
    public List<Worker> getAll() {
        return List.of();
    }
}
