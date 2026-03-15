package in.sarveshsawant.taskvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sarveshsawant.taskvision.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
