package Project_sala.demo.Service;


import Model_project.demo.Model.Room;

import java.util.List;

public interface RoomServiceInterface {
    Room createRoom(Room room);
    Room updateRoom(Room room);
    void deleteRoom(Long id);
    List<Room> gellAllRooms();
}
