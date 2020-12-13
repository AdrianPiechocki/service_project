package service_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service_project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
