package seongin_backend.hello_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seongin_backend.hello_spring.repository.MemberRepository;
import seongin_backend.hello_spring.repository.MemoryMemberRepository;
import seongin_backend.hello_spring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
