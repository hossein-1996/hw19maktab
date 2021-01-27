package entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static javax.persistence.TemporalType.DATE;


@Data
@Entity
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String beginning;

    @Column
    private String destination;

    @Column
    @Temporal(DATE)
    private java.util.Date dateOfDeparture;

    @Column
    private LocalTime hourOfDeparture;

    @OneToMany(mappedBy = "direction")
    private List<Ticket> ticket;

}
