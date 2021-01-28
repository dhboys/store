package org.zerock.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

	// 가능하면 객체형 자료로 잡는다
	private Long sno;     // 수치이기 때문에 null이 중요
	private String name;
	private double lat,lng;  // 수치이기 때문에 기본자료형
	private String menu;
	private Date regdate , updateDate;
	
}