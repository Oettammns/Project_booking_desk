package Project_book.demo.BookRepository;


import Model_project.demo.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Booking,Long> {
    /*query che fa riferimento al db condivido dai tre ed in particolare alla table
    * desk*/
}
