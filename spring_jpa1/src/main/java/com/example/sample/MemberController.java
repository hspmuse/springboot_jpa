package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/member/{id}")
    @GetMapping
    public MemberDomain getMember (@PathVariable("id") long id) {
        return memberService.findone(id);
    }

    @RequestMapping("/member/insert")
    @PostMapping
    public MemberDomain insertMember() {
        MemberDomain memberDomain = new MemberDomain();
        memberDomain.setAge(10);
        memberDomain.setName("test");
        memberService.save(memberDomain);

        return memberService.findone(memberDomain.getId());
    }

    @RequestMapping("/member/list/{name}")
    public List<MemberDomain> getMemberList(@PathVariable("name") String name) { return memberService.findByName(name);}

    @RequestMapping("/member/list1/{name}")
    public List<MemberDomain> getMemberList1(@PathVariable("name") String name) { return memberService.findByName1(name);}
}
