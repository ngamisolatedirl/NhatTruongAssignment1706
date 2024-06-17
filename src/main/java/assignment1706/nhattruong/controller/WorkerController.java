package assignment1706.nhattruong.controller;

import assignment1706.nhattruong.dto.WorkerDto;
import assignment1706.nhattruong.entity.Worker;
import assignment1706.nhattruong.service.WorkerService;
import assignment1706.nhattruong.service.impl.WorkerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class WorkerController {
WorkerService workerService = new WorkerServiceImpl();
@GetMapping(value ="/workers")
public List<WorkerDto> getWorkers() {return workerService.findAll();}
    @PostMapping(value = "/addWorker")
    public void addWorker(@RequestBody WorkerDto workerDto) {
        workerService.addWorker(workerDto);}

}
