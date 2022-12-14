package Project_book.demo.Model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private Time time;
    @Column(name = "room_id")
    private long room_id;
    @Column(name = "desk_id")
    private long desk_id;

    public Booking() {
    }

    public long getId() {
        return id;
    }

    public long getRoom_id() {
        return room_id;
    }

    public long getDesk_id() {
        return desk_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
