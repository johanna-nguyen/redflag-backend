package johannanguyen.redflagbackend.controller;

import johannanguyen.redflagbackend.entity.Report;
import johannanguyen.redflagbackend.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {
    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Report> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Report create(@RequestBody Report r) {
        return service.save(r);
    }

    @GetMapping("/search")
    public List<Report> search(@RequestParam String name) {
        return service.search(name);
    }
}
