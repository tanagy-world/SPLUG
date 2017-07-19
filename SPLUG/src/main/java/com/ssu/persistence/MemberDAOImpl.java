package com.ssu.persistence;

import org.springframework.stereotype.Repository;

import com.ssu.domain.MemberVO;

@Repository
public class MemberDAOImpl extends GenericDAOImpl<MemberVO, String> implements MemberDAO {

}
