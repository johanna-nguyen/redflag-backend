package johannanguyen.redflagbackend.repository;

import johannanguyen.redflagbackend.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByFirstNameContainingIgnoreCase(String name);
}
