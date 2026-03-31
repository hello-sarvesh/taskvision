package in.sarveshsawant.taskvision.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.sarveshsawant.taskvision.entity.Task;
import in.sarveshsawant.taskvision.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public Page<Task> getTaskPageList(String searchTerm, int pageNumber, int pageSize, String pageSortBy,
            boolean pageSortAsc) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return taskRepository.findAll(pageable);
    }



}
