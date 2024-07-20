package test.performance.backend.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    public Member(String nickname) {
        this.nickname = nickname;
    }

    protected Member() {
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }
}
