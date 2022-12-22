package Model_project.demo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "desk")
public class Desk {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "pos_x")
    private int pos_x;
    @Column(name = "pos_y")
    private int pos_y;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_room_id")
    private Room room;

    @OneToMany(mappedBy = "desk_id", cascade = CascadeType.ALL)
    private List<Booking> booking;


    public Desk() {
    }

    public Desk(int pos_x, int pos_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;

    }

    public long getId() {
        return id;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }
}
