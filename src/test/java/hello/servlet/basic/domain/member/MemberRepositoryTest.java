package hello.servlet.basic.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void tearDown() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        final Member member = new Member("hello", 20);
        final Member savedMember = memberRepository.save(member);
        assertThat(memberRepository.findById(savedMember.getId())).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        final Member member1 = new Member("member1", 20);
        final Member member2 = new Member("member2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);

        final List<Member> result = memberRepository.findAll();
        assertThat(result).hasSize(2);
        assertThat(result).contains(member1, member2);
    }
}