package test.performance.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    @Builder
    private Member(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    protected Member() {
    }
}
