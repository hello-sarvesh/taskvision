package in.sarveshsawant.taskvision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    @GetMapping(path = {"","/"})
    public String getTaskHome() {
        return "tasks/task";
    }
}
