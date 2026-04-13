package johannanguyen.redflagbackend.repository;

import johannanguyen.redflagbackend.entity.Report;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long>{
    List<Report> findByFirstNameContainingIgnoreCase(String name);
}
