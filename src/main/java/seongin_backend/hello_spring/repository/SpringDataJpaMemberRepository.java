package seongin_backend.hello_spring.repository;

import seongin_backend.hello_spring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaMemberRepository<Member, Long>, MemberRepository {

}
