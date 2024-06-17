package assignment1706.nhattruong.repository;

import assignment1706.nhattruong.entity.Worker;
import assignment1706.nhattruong.jpaRepository.main.impl.JpaExecutorImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerRepositoryReflect extends JpaExecutorImpl<Worker> {

    public WorkerRepositoryReflect(Class<Worker> clazz) {
        super(clazz);
    }

    public static void main(String[] args) {
        WorkerRepositoryReflect repo = new WorkerRepositoryReflect(Worker.class);
        repo.findAll();
    }

    @Override
    public List<Worker> rowMapper(ResultSet rs) {
        List<Worker> workers = new ArrayList<>();
        try {
            while (rs.next()) {
                Worker s = new Worker();
                s.setId(rs.getLong("id"));
                s.setFullname(rs.getString("fullname"));
                s.setBirthday(rs.getString("birthday"));
                s.setAddress(rs.getString("address"));
                s.setPosition(rs.getString("position"));
                s.setDepartment(rs.getString("department"));
                workers.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workers;
    }

    @Override
    protected void mapToPreparedStatement(PreparedStatement pt, Worker worker) throws SQLException {
        pt.setLong(1, worker.getId());
        pt.setString(2, worker.getFullname());
        pt.setString(3,worker.getBirthday());
        pt.setString(4, worker.getAddress());
        pt.setString(5, worker.getPosition());
        pt.setString(6, worker.getDepartment());

    }

}
