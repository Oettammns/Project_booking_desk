package Model_project.demo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "room" ,cascade = CascadeType.ALL)
    private List<Desk> desks;

    @OneToMany(mappedBy = "room_id", cascade = CascadeType.ALL)
    private List<Booking> booking;

    public Room() {
    }

    public Room(String name, String address){
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
