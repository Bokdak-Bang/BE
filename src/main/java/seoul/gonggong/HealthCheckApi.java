package seoul.gonggong;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckApi {
    @GetMapping("/")
    public ResponseEntity<HttpStatus> hello() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/health-check")
    public String check() {
        return "hello";
    }

}
