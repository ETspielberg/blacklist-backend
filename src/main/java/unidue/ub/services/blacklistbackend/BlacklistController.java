package unidue.ub.services.blacklistbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlacklistController {

    private final IgnoredRepository ignoredRepository;


    @Autowired
    public BlacklistController(IgnoredRepository ignoredRepository) {
        this.ignoredRepository = ignoredRepository;
    }

    @GetMapping("/getIgnoredFor/{identifier}")
    public ResponseEntity<?> getIgnoredForIdentifier(@PathVariable String identifier) {
        return ResponseEntity.ok(this.ignoredRepository.findAllByTitleId(identifier));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllIgnored() {
        List<Ignored> ignoredList = new ArrayList<>();
        for (Ignored ignored: this.ignoredRepository.findAll())
            ignoredList.add(ignored);
        return ResponseEntity.ok(ignoredList);
    }

}
