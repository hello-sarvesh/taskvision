package in.sarveshsawant.taskvision.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToMany(mappedBy = "projects")
    private List<User> members;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean active;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean deleted;

    @Column(name = "created_at_utc")
    private LocalDateTime createdAtUTC;

    @Column(name = "updated_at_utc")
    private LocalDateTime updatedAtUTC;

}
