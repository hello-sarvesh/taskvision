package in.sarveshsawant.taskvision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @GetMapping(path = {"","/"})
    public String getProjectHome() {
        return "projects/project";
    }
}
