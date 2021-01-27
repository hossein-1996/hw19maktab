package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String beginning;

    @Column
    private String Destination;

    @Column
    private Date DateOfDeparture;

    @Column
    private String HourOfDeparture;

    @ManyToOne
    private Direction direction;

    @ManyToOne
    private TicketList ticketList;

}
