package in.sarveshsawant.taskvision.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sarveshsawant.taskvision.dto.TaskStatusForm;
import in.sarveshsawant.taskvision.entity.TaskStatus;
import in.sarveshsawant.taskvision.service.TaskStatusService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/task-status")
public class TaskStatusController {

     private final TaskStatusService taskStatusService;

    @GetMapping(path = { "", "/" })
    public String getTaskHome(Model model) {
        TaskStatusForm form = new TaskStatusForm();
    form.setStatuses(taskStatusService.findAllByOrderByOrderIndexAsc());
    model.addAttribute("form", form);
        return "task-status/task-status";
    }

    @PostMapping("/save")
public String save(@ModelAttribute TaskStatusForm form) {

    List<TaskStatus> list = form.getStatuses();

    // reassign order (VERY important)
    for (int i = 0; i < list.size(); i++) {
        list.get(i).setOrderIndex((long) i);
    }

    taskStatusService.saveAllTaskStatuses(list);

    return "redirect:/task-status";
}

}
