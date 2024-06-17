package assignment1706.nhattruong.service;

import assignment1706.nhattruong.dto.WorkerDto;

import java.util.List;

public interface WorkerService {
    List<WorkerDto> findAll();
    void addWorker(WorkerDto worker);
}
