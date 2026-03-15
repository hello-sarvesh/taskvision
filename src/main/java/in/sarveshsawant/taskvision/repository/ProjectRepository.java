package in.sarveshsawant.taskvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sarveshsawant.taskvision.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
