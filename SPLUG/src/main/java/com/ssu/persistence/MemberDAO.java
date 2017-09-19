package com.ssu.persistence;

import com.ssu.domain.MemberVO;

public interface MemberDAO extends GenericDAO<MemberVO, String>{

	String getTime(); 

}
