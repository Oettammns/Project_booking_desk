package Project_desk.demo.DeskRepository;

import Model_project.demo.Model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<Desk,Long> {
}
