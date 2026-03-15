package in.sarveshsawant.taskvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sarveshsawant.taskvision.entity.TaskType;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {

}
