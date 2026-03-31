package in.sarveshsawant.taskvision.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sarveshsawant.taskvision.entity.Project;
import in.sarveshsawant.taskvision.entity.Task;
import in.sarveshsawant.taskvision.entity.TaskType;
import in.sarveshsawant.taskvision.entity.User;
import in.sarveshsawant.taskvision.repository.ProjectRepository;
import in.sarveshsawant.taskvision.repository.TaskStatusRepository;
import in.sarveshsawant.taskvision.repository.TaskTypeRepository;
import in.sarveshsawant.taskvision.repository.UserRepository;
import in.sarveshsawant.taskvision.service.TaskService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final TaskTypeRepository taskTypeRepository;
    private final TaskStatusRepository taskStatusRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @GetMapping(path = { "", "/" })
    public String getTaskHome(@RequestParam(defaultValue = "") String searchTerm,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "") String pageSortBy,
            @RequestParam(defaultValue = "true") boolean pageSortAsc,
            Model model) {
        Page<Task> taskPage = taskService.getTaskPageList(searchTerm, pageNumber, pageSize, pageSortBy,
                pageSortAsc);
        model.addAttribute("taskPage", taskPage);
        return "tasks/task";
    }

    @GetMapping(path = { "/new", "/new/" })
    public String addTask(Model model) {

        List<TaskType> taskTypes = taskTypeRepository.findAll();
        List<Project> projects = projectRepository.findAll();
        List<User> users =userRepository.findAll();

        model.addAttribute("task", new Task());
        model.addAttribute("taskTypes", taskTypes);
        model.addAttribute("projects", projects);
        model.addAttribute("users", users);
        return "tasks/addTask";
    }
}
