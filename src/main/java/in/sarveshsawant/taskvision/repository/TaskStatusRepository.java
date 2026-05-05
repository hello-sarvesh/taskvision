package in.sarveshsawant.taskvision.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.sarveshsawant.taskvision.entity.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {

    /*~~(class org.openrewrite.java.tree.J$Erroneous cannot be cast to class org.openrewrite.java.tree.J$Assignment (org.openrewrite.java.tree.J$Erroneous and org.openrewrite.java.tree.J$Assignment are in unnamed module of loader 'app'))~~>*/@Query("SELECT t FROM TaskStatus t ORDER BY t.orderIndex asc")
    List<TaskStatus> findAllByOrderByOrderIndexAsc();

}
