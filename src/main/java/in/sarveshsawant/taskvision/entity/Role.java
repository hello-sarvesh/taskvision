package in.sarveshsawant.taskvision.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles", uniqueConstraints = {
        @UniqueConstraint(name = "uk_role_role", columnNames = { "role" })
})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private String active;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private String deleted;

    @Column(name = "create_at_utc")
    private LocalDateTime createAtUTC;

    @Column(name = "update_at_utc")
    private LocalDateTime updatedAtUTC;
}
