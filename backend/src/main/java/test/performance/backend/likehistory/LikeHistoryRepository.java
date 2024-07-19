package test.performance.backend.likehistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeHistoryRepository extends JpaRepository<LikeHistory, Long> {
}
