package assignment1706.nhattruong.mapper.impl;

import assignment1706.nhattruong.dto.WorkerDto;
import assignment1706.nhattruong.entity.Worker;
import assignment1706.nhattruong.mapper.WorkerMapper;
import org.springframework.beans.BeanUtils;

public class WorkerMapperImpl implements WorkerMapper {
    @Override
    public Worker DtoToEntity(WorkerDto dto) {
        Worker worker  = new Worker();
        BeanUtils.copyProperties(dto,worker);
        return worker;
    }

    @Override
    public WorkerDto EntityToDto(Worker entity) {
        WorkerDto dto = new WorkerDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }
}
