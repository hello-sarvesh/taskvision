package in.sarveshsawant.taskvision.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sarveshsawant.taskvision.entity.Project;
import in.sarveshsawant.taskvision.service.ProjectService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping(path = { "", "/" })
    public String getProjectHome(
            @RequestParam(defaultValue = "") String searchTerm,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "") String pageSortBy,
            @RequestParam(defaultValue = "true") boolean pageSortAsc,
            Model model) {
        Page<Project> projectPage = projectService.getProjectPageList(searchTerm, pageNumber, pageSize, pageSortBy,
                pageSortAsc);
        model.addAttribute("projectPage", projectPage);
        return "projects/project";
    }

    @GetMapping(path = { "/new", "/new/" })
    public String addProject(Model model) {
        model.addAttribute("project", new Project());
        return "projects/addProject";
    }

    @PostMapping(path = { "/save", "/save/" })
    public String saveProject(@ModelAttribute Project newProject, Model model) {
        System.out.println("project " + newProject.toString());
        projectService.saveProject(newProject);
        return "redirect:/project";
    }

    @GetMapping(path = { "/view-{id}", "/view-{id}/" })
    public String viewProject(
            @PathVariable Long id,
            Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "projects/viewProject";
    }

    @GetMapping(path = { "/delete-{id}", "/delete-{id}/" })
    public String deleteProjectPage(
            @PathVariable Long id,
            Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "projects/deleteProject";
    }

    @DeleteMapping(path = { "/delete-confirm-{id}", "/delete-confirm-{id}/" })
    public String deleteProject(@PathVariable Long id,
            Model model) {
        projectService.deleteProject(id);
        return "redirect:/project";
    }
}
