package in.sarveshsawant.taskvision.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.sarveshsawant.taskvision.entity.Project;
import in.sarveshsawant.taskvision.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public void saveProject(Project newProject) {

        LocalDateTime utcDateTime = LocalDateTime.now(ZoneOffset.UTC);
        newProject.setCreatedAtUTC(utcDateTime);
        newProject.setActive(true);
        newProject.setDeleted(false);
        projectRepository.save(newProject);
    }

    public Page<Project> getProjectPageList(String searchTerm, int pageNumber, int pageSize, String pageSortBy,
            boolean pageSortAsc) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return projectRepository.findAll(pageable);
    }

    public Project getProjectById(Long id) {
        return projectRepository.getReferenceById(id);
    }
}
