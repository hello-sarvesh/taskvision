package in.sarveshsawant.taskvision.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_task_id")
    private Task parentTask;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporting_user_id")
    private User reportingUser;

    @ManyToOne
    @JoinColumn(name = "task_type_id")
    private TaskType type;

    @ManyToOne
    @JoinColumn(name = "task_status_id")
    private TaskStatus status;

    @Column(name = "expected_hours")
    private Double expectedHours;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<TaskTimeLog> timeLogs;

    @Column(name = "created_at_utc")
    private LocalDateTime createAtUTC;

    @Column(name = "updated_at_utc")
    private LocalDateTime updatedAtUTC;

    @Transient
    public Double getCompletedHours() {
        if (timeLogs == null)
            return 0.0;
        return timeLogs.stream()
                .mapToDouble(TaskTimeLog::getHours)
                .sum();
    }

    @Transient
    public Double getRemainingHours() {
        return expectedHours - getCompletedHours();
    }

}
