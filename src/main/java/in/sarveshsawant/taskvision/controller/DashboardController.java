package in.sarveshsawant.taskvision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping(path = {"","/"})
    public String getDashboardHome() {
        return "dashboard/dashboard";
    }

}
