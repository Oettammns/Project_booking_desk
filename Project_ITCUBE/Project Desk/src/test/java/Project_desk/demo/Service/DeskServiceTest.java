package Project_desk.demo.Service;

import Model_project.demo.Model.Desk;
import Project_desk.demo.DeskRepository.DeskRepository;
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

class DeskServiceTest {
    @Autowired
    @InjectMocks
    DeskService service;

    @Mock
    DeskRepository deskRepository;

    @Test
    void createDesk() {
        Desk desk = new Desk(1,1);
        when(deskRepository.save(any(Desk.class))).thenReturn(desk);
    }

    @Test
    void updateDesk() {
        Desk expected = new Desk(5,7);
        Desk updated = new Desk(8,7);
        when(deskRepository.save(any(Desk.class))).thenReturn(updated);
        when(deskRepository.findById(anyLong())).thenReturn(Optional.of(expected));

        final Desk actual=service.updateDesk(updated);

        assertEquals(actual.getPos_x(),expected.getPos_x());
        assertEquals(actual.getId(),expected.getId());

    }

    @Test
    void deleteDesk() {
        long id = 1L;

        doNothing().when(deskRepository).deleteById(1L);

        service.deleteDesk(id);
        verify(deskRepository,times(1)).deleteById(id);
        verifyNoMoreInteractions(deskRepository);
    }

    @Test
    void getAllDesks() {
        Desk d1 = new Desk(1,1);
        Desk d2 = new Desk(1,2);
        when(deskRepository.findAll()).thenReturn(List.of(d1,d2));

        List<Desk> deskList = service.getAllDesks();

        assertNotNull(deskList);
        assertEquals(deskList.size(),2);
    }
}