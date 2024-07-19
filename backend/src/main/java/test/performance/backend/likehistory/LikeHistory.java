package test.performance.backend.likehistory;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import test.performance.backend.member.Member;
import test.performance.backend.post.Post;

@Entity
public class LikeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Builder
    private LikeHistory(Long id, Member member, Post post) {
        this.id = id;
        this.member = member;
        this.post = post;
    }

    protected LikeHistory() {
    }
}
