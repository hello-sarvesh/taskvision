package in.sarveshsawant.taskvision.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.sarveshsawant.taskvision.entity.Task;
import in.sarveshsawant.taskvision.entity.TaskStatus;
import in.sarveshsawant.taskvision.repository.TaskStatusRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskStatusService {

    private final TaskStatusRepository taskStatusRepository;

    public List<TaskStatus> getAllTaskStatuses() {
        return taskStatusRepository.findAll();
    }

    public void saveAllTaskStatuses(List<TaskStatus> taskStatuses) {
        taskStatusRepository.saveAll(taskStatuses);
    }

    public List<TaskStatus> findAllByOrderByOrderIndexAsc() {
        return taskStatusRepository.findAllByOrderByOrderIndexAsc();
    }
}
