package in.sarveshsawant.taskvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sarveshsawant.taskvision.entity.TaskTimeLog;

public interface TaskTimeLogRepository extends JpaRepository<TaskTimeLog, Long> {

}
