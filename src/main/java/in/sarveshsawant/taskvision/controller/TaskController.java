package in.sarveshsawant.taskvision.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping(path = { "/save", "/save/" })
    public String saveTask(@ModelAttribute Task newTask, Model model) {
        System.out.println("task " + newTask.toString());
        taskService.saveTask(newTask);
        return "redirect:/task";
    }

    @GetMapping(path = { "/view-{id}", "/view-{id}/" })
    public String viewTask(
            @PathVariable Long id,
            Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "tasks/viewTask";
    }

    @GetMapping(path = { "/delete-{id}", "/delete-{id}/" })
    public String deleteTaskPage(
            @PathVariable Long id,
            Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "tasks/deleteTask";
    }

    @DeleteMapping(path = { "/delete-confirm-{id}", "/delete-confirm-{id}/" })
    public String deleteTask(@PathVariable Long id,
            Model model) {
        taskService.deleteTask(id);
        return "redirect:/task";
    }

    @GetMapping(path = { "/update-{id}", "/update-{id}/" })
    public String updateTask(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);

        List<TaskType> taskTypes = taskTypeRepository.findAll();
        List<Project> projects = projectRepository.findAll();
        List<User> users =userRepository.findAll();

        model.addAttribute("taskTypes", taskTypes);
        model.addAttribute("projects", projects);
        model.addAttribute("users", users);
        return "tasks/updateTask";
    }

    @PutMapping(path = { "/update", "/update/" })
    public String updateSaveTask(@ModelAttribute Task updatedTask, Model model) {
        System.out.println("task " + updatedTask.toString());
        taskService.saveTask(updatedTask);
        return "redirect:/task";
    }
}
