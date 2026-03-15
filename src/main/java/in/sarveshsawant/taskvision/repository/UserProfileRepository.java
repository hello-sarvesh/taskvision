package in.sarveshsawant.taskvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sarveshsawant.taskvision.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
