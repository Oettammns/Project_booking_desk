package Project_desk.demo.Service;


import Model_project.demo.Model.Desk;

import java.util.List;


public interface DeskServiceInterface {
    Desk createDesk(Desk desk);
    Desk updateDesk(Desk desk);
    void deleteDesk(Long id);
    List<Desk> getAllDesks(/*Room room*/);
}
