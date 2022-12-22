package Project_book.demo.Service;

import Model_project.demo.Model.Booking;
import Project_book.demo.BookRepository.BookRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Autowired
    @InjectMocks
    BookService service;

    @Mock
    BookRepository bookRepository;

    @Test
    void createBooking() {
        Booking booking = new Booking();
        when(bookRepository.save(any(Booking.class))).thenReturn(booking);
    }

    @Test
    void deleteBooking() {
        long id = 1L;

        doNothing().when(bookRepository).deleteById(1L);

        service.deleteBooking(id);
        verify(bookRepository,times(1)).deleteById(id);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void getAllBooking() {
        Booking b1 = new Booking();
        Booking b2 = new Booking();
        when(bookRepository.findAll()).thenReturn(List.of(b1,b2));

        List<Booking> bookingList = service.getAllBooking();


        assertNotNull(bookingList);
        assertEquals(bookingList.size(),2);
    }
}