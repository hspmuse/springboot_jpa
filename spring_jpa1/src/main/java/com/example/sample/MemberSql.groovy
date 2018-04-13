package com.example.sample

class MemberSql {

    public static final String SELECT_MEMBER_FIND_NAME = """
        SELECT  id, age, name
        FROM MEMBER
        WHERE NAME = :name
    """;
}
