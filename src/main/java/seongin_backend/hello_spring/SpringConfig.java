package seongin_backend.hello_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seongin_backend.hello_spring.repository.JdbcMemberRepository;
import seongin_backend.hello_spring.repository.JdbcTemplateMemberRepository;
import seongin_backend.hello_spring.repository.MemberRepository;
import seongin_backend.hello_spring.repository.MemoryMemberRepository;
import seongin_backend.hello_spring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository()
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
