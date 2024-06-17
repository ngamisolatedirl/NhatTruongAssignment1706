package assignment1706.nhattruong.mapper;

import assignment1706.nhattruong.dto.WorkerDto;
import assignment1706.nhattruong.entity.Worker;

public interface WorkerMapper {
    Worker DtoToEntity(WorkerDto dto);
    WorkerDto EntityToDto(Worker entity);
}
