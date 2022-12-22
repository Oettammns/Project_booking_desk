package Project_sala.demo.Service;

import Model_project.demo.Model.Room;
import Project_sala.demo.RoomRepository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class RoomServiceTest {

    @Autowired
    @InjectMocks
    RoomService service;

    @Mock
    RoomRepository roomRepository;

    @Test
    void createRoom() {
        Room room = new Room("Einaudi","via Centro");
        when(roomRepository.save(any(Room.class))).thenReturn(room);
    }

    @Test
    void updateRoom() {
        Room expected = new Room("Einaudi","via Centro");
        Room updated = new Room("Einaudi", "via Nord");
        when(roomRepository.save(any(Room.class))).thenReturn(updated);
        when(roomRepository.findById(anyLong())).thenReturn(Optional.of(expected));

        final Room actual=service.updateRoom(updated);

        assertEquals(actual.getAddress(),expected.getAddress());
        assertEquals(actual.getId(),expected.getId());

    }

    @Test
    void deleteRoom() {
        long id = 1L;

        doNothing().when(roomRepository).deleteById(1L);

        service.deleteRoom(id);
        verify(roomRepository,times(1)).deleteById(id);
        verifyNoMoreInteractions(roomRepository);
    }

    @Test
    void gellAllRooms() {
        Room r1 = new Room("Einaudi","via Centro");
        Room r2 = new Room("Mazzini", "via Mazzini");
        when(roomRepository.findAll()).thenReturn(List.of(r1,r2));

        List<Room> roomList = service.gellAllRooms();


        assertNotNull(roomList);
        assertEquals(roomList.size(),2);
    }
}