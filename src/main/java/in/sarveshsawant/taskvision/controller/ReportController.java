package in.sarveshsawant.taskvision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

    @GetMapping(path = {"","/"})
    public String getReportHome() {
        return "reports/report";
    }
}
