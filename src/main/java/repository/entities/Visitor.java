package repository.entities;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "visitor_table")
@ToString @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visitor_id")
    private int visitorID;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "checkin_time")
    private Date checkinTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "checkout_time")
    private Date checkoutTime;

    @Column(name = "duration")
    private String duration;

    @Column(name = "purpose_of_visit")
    private String purposeOfVisit;

    @Column(name = "company_or_organization")
    private String companyOrOrganization;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "visitor_type")
    private VisitorType visitorType;
}
