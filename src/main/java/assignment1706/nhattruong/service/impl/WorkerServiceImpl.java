package assignment1706.nhattruong.service.impl;

import assignment1706.nhattruong.dto.WorkerDto;
import assignment1706.nhattruong.entity.Worker;
import assignment1706.nhattruong.mapper.WorkerMapper;
import assignment1706.nhattruong.mapper.impl.WorkerMapperImpl;
import assignment1706.nhattruong.repository.WorkerRepository;
import assignment1706.nhattruong.repository.WorkerRepositoryReflect;
import assignment1706.nhattruong.repository.impl.WorkerRepositoryImpl;
import assignment1706.nhattruong.service.WorkerService;

import java.util.List;
import java.util.stream.Collectors;

public class WorkerServiceImpl implements WorkerService {
    WorkerRepository workerRepository = new WorkerRepositoryImpl();
    WorkerMapper workerMapper = new WorkerMapperImpl();
    WorkerRepositoryReflect workerRepositorydeptrai = new WorkerRepositoryReflect(Worker.class);

    @Override
    public List<WorkerDto> findAll() {
        List<Worker> workers = workerRepositorydeptrai.findAll();
        return workers.stream()
                .map(workerMapper::EntityToDto).collect(Collectors.toList());
    }
    @Override
    public void addWorker(WorkerDto workerDto) {
        Worker worker = workerMapper.DtoToEntity(workerDto);
        workerRepositorydeptrai.add(worker);
    }

}