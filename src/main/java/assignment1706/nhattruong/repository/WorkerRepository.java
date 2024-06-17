package assignment1706.nhattruong.repository;

import assignment1706.nhattruong.entity.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerRepository {
    List<Worker> getAll();
    void addWorker(Worker worker);
}
