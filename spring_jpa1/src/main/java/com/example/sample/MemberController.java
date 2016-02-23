package com.example.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @RequestMapping("/member")
    @ResponseBody
    public String getMember() {
        return MemberSql.mSql;
    }

    @RequestMapping("/member/insert")
    @ResponseBody
    public String insertMember() {
        return MemberSql.mInsert;
    }
}
