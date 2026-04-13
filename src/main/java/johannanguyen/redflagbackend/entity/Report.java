package johannanguyen.redflagbackend.entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;   // 1 letter
    private String lastName;    // 1 letter
    private String nationality;
    private String birthDate;
    private String job;
    private String category;
}
