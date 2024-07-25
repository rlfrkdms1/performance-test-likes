package test.performance.backend.likehistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.performance.backend.exception.MemberNotFoundException;
import test.performance.backend.exception.PostNotFountException;
import test.performance.backend.member.Member;
import test.performance.backend.member.MemberRepository;
import test.performance.backend.post.Post;
import test.performance.backend.post.PostRepository;

@Service
@Transactional(readOnly = true)
public class LikeHistoryService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final LikeHistoryRepository likeHistoryRepository;

    @Autowired
    public LikeHistoryService(PostRepository postRepository, MemberRepository memberRepository, LikeHistoryRepository likeHistoryRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
        this.likeHistoryRepository = likeHistoryRepository;
    }

    @Transactional
    public void done(Long memberId, Long postId) {
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        Post post = postRepository.findById(postId).orElseThrow(PostNotFountException::new);
        likeHistoryRepository.save(new LikeHistory(member, post));
    }

    @Transactional
    public void doneWithWrite(Long memberId, Long postId) {
        Member member = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        Post post = postRepository.findById(postId).orElseThrow(PostNotFountException::new);
        likeHistoryRepository.save(new LikeHistory(member, post));
        post.like();
    }
}
