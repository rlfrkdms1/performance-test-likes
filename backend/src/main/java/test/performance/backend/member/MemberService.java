package test.performance.backend.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public CreateMemberResponse create() {
        Member member = memberRepository.save(new Member(UUID.randomUUID().toString()));
        return new CreateMemberResponse(member.getId());
    }
}
