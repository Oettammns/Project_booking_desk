package Model_project.demo.Model;

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

    @ManyToOne(cascade = CascadeType.ALL)
    /*
    @JoinTable(
            name = "booking_room",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))*/
    @JoinColumn(name = "room_id")
    private Room room_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "desk_id")
    private Desk desk_id;

    public Booking() {
    }

    public long getId() {
        return id;
    }

    public Room getRoom_id() {
        return room_id;
    }

    public Desk getDesk_id() {
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
