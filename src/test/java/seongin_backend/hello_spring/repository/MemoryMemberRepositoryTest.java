package seongin_backend.hello_spring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import seongin_backend.hello_spring.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() { //메서드 동작 끝날때마다 탐
        //test case는 순서보장이 안 돼서 매번 클리어 해줘야함
        //테스트는 순서와 상관없이 의존관계 없이 설계되어야함
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("성인");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = "+(result == member));
        //jupiter.api.Assertions  Assertions.assertEquals(member, result);
        //assertj
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("성인1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("성인2");
        repository.save(member2);

        Member result = repository.findByName("성인2").get();

        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("성인1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("성인2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result).size().isEqualTo(2);
    }
}
