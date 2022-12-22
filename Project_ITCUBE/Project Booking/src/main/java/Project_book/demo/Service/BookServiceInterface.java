package Project_book.demo.Service;

import Model_project.demo.Model.Booking;

import java.util.List;

public interface BookServiceInterface {

    Booking createBooking(Booking booking);
    void deleteBooking(Long id);
    List<Booking> getAllBooking();
}
