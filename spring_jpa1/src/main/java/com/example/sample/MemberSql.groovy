package com.example.sample


class MemberSql {

    public static final String mSql = """

        SELECT * from member

    """

    public static final String mInsert = """
insert into member values (:id,:name)
"""
}
