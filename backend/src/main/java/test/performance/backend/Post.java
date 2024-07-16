package test.performance.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private long likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    private Post(Long id, String title, String content, long likes, Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.member = member;
    }

    protected Post() {

    }
}
