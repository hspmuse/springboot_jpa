package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberJtRepository memberJtRepository;

    public MemberDomain findone(long id) {
        return memberRepository.findOne(id);
    }

    public List<MemberDomain> findAll() {
        return memberRepository.findAll();
    }

    public List<MemberDomain> findByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<MemberDomain> findByName1(String name) {
        return memberJtRepository.findByName(name);
    }

    public void save(MemberDomain memberDomain) {
        memberRepository.save(memberDomain);
    }
}
