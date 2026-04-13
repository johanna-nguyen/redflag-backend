package johannanguyen.redflagbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RedflagTestController {
    private List<Map<String, Object>> reports = new ArrayList<>();

    public RedflagTestController() {
        Map<String, Object> r1 = new HashMap<>();
        r1.put("id", 1);
        r1.put("title", "Report A");
        r1.put("status", "OPEN");

        Map<String, Object> r2 = new HashMap<>();
        r2.put("id", 2);
        r2.put("title", "Report B");
        r2.put("status", "DONE");

        reports.add(r1);
        reports.add(r2);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Redflag backend running 🚀";
    }

    @GetMapping("/reports")
    public List<Map<String, Object>> getAll() {
        return reports;
    }
}
