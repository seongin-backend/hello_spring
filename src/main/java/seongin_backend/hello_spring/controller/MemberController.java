package seongin_backend.hello_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seongin_backend.hello_spring.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) { //Autowired Spring 컨테이너끼리 잇는 역할
        this.memberService = memberService;
    }
}

