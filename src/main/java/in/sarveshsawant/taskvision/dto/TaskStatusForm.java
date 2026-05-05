package in.sarveshsawant.taskvision.dto;

import java.util.List;

import in.sarveshsawant.taskvision.entity.TaskStatus;
import lombok.Data;

@Data
public class TaskStatusForm {

     private List<TaskStatus> statuses;
}
