package entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TicketList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private Date date;

    @OneToMany(mappedBy = "ticketList")
    private List<Ticket> tickets;
}
