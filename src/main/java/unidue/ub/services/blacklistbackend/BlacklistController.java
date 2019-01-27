package unidue.ub.services.blacklistbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
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
        for (Ignored ignored : this.ignoredRepository.findAll())
            ignoredList.add(ignored);
        return ResponseEntity.ok(ignoredList);
    }

    @GetMapping("isBlocked/{identifier}")
    public ResponseEntity<Boolean> isBlocked(@PathVariable String identifier, String type) {
        boolean isblocked = false;
        Date today = new Date();
        List<Ignored> ignoreds;
        if (type != null)
            ignoreds = ignoredRepository.findAllByTitleIdAndAndType(identifier, type);
        else
            ignoreds = ignoredRepository.findAllByTitleId(identifier);
        for (Ignored ignored : ignoreds) {
            if (ignored.getExpire().after(today)) {
                isblocked = true;
                break;
            }
        }
        return ResponseEntity.ok(isblocked);
    }

}
