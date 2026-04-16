package johannanguyen.redflagbackend.entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name="reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;   // 1 letter
    private String lastName;    // 1 letter
    private String nationality;
    private String birthDate;
    private String job;
    private List<String> category;
}
