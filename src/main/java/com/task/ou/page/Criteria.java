package com.task.ou.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
	
	private int pageNum; //페이지번호
	private int amount; //한 페이지 당 몇개의 게시글을 보여줄 것인지
	
	public Criteria() {
		this(1,10); //페이지당 10개
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}