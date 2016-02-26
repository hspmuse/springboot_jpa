package com.example.sample;

import com.example.SpringbootJpa1Application;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootJpa1Application.class)
@WebAppConfiguration
public class MemberServiceTest extends TestCase {

    @Autowired
    private MemberService memberService;

    @Test
    public void MemberServiceTest() {

        String name = "mark1";


        MemberDomain memberDomain = new MemberDomain();
        memberDomain.setAge(10);
        memberDomain.setName("mark1");

        memberService.save(memberDomain);

        assertEquals(memberService.findone(memberDomain.getId()).getName(), "mark1");

        MemberDomain memberDomain2 = new MemberDomain();
        memberDomain2.setAge(10);
        memberDomain2.setName("mark1");
        memberService.save(memberDomain2);

        assertTrue(memberService.findByName("mark1").size() > 1);

    }
}