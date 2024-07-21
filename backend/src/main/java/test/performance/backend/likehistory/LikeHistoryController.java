package test.performance.backend.likehistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/like-history")
public class LikeHistoryController {

    private final LikeHistoryService likeHistoryService;

    @Autowired
    public LikeHistoryController(LikeHistoryService likeHistoryService) {
        this.likeHistoryService = likeHistoryService;
    }

    @PostMapping("/{likeHistoryId}")
    public ResponseEntity<Void> like(Long memberId, @PathVariable Long likeHistoryId) {
        likeHistoryService.done(memberId, likeHistoryId);
        return ResponseEntity.ok().build();
    }
}
