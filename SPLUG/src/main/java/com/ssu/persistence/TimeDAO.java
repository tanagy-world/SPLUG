package com.ssu.persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

// 吏湲????대옒?ㅻ뒗 ?ㅽ봽留??꾨줈?앺듃??湲곕낯 ?⑦궎吏媛 ?꾨땲誘濡?Spring??愿由ы븯???⑦궎吏媛 ?꾨땲?? 洹몃옒???곕줈 ?ㅼ젙?댁＜?댁빞 ?쒕떎.
@Repository
public class TimeDAO {

	@Inject
	DataSource ds;// DataSource??낆쓽 bean???꾩옱??root-context???섎굹諛뽰뿉 ?놁쑝誘濡? bean??id?
				    // ?몄뒪?댁뒪 蹂???대쫫???ㅻⅤ?붾씪??二쇱엯???섏엳??
	public String getTime() throws Exception{
		
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select now()");
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		return rs.getString(1);// ?꾩옱 ?좎쭨媛 諛섑솚?쒕떎.
	}//getTime()

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
}// class
