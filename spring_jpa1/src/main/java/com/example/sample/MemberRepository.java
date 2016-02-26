package com.example.sample;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberDomain,Long> {

    public List<MemberDomain> findByName(String name);
}
