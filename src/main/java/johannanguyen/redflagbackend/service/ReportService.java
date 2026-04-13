package johannanguyen.redflagbackend.service;

import johannanguyen.redflagbackend.entity.Report;
import johannanguyen.redflagbackend.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository repo;

    public ReportService(ReportRepository repo) {
        this.repo = repo;
    }

    public List<Report> getAll() {
        return repo.findAll();
    }

    public Report save(Report r) {
        return repo.save(r);
    }

    public List<Report> search(String name) {
        return repo.findByFirstNameContainingIgnoreCase(name);
    }
}
