package com.task.ou.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {

	private int startPage; // 화면에 보여지는 페이지 시작 번호
	private int endPage; // 화면에 보여지는 페이지 끝 번호

	private boolean pre, next; // 이전과 다음으로 이동가능한 링크 표시

	// '<<' 버튼 출력여부(만약 1페이지면 <<는 필요없으므로 출력여부가 필요)
	// '>>' 버튼 출력여부(만약 다음페이지가 없으면 >>는 필요없으므로 출력여부가 필요

	private int total; // 전체 게시판 글 수

	private Criteria cri;

	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		// 먼저 endPage 부터 계산
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;

		// 현재페이지 정보로부터 끝페이지에 대한 연산
		// ex) 현재 페이지(pageInfo.getPage()) = 3
		// 하단 페이징 바에 보여줄 페이징바 개수 = displayPageNum = 10개
		// 연산 : ceil(3 / 10.0) * 10 => 1 * 10 = 10까지
		// 1.(3/10.0)=0.3
		// 2. ceil(0.3) = 1
		// 3. 1*10 = 10
		// 1 2 3 4 5 6 7 8 9

		// ex2) 현재 페이지 (cri.getPageNum())=13
		// 하단 페이징 바에 보여줄 페이징바 개수 = displayPageNum = 10개
		// 연산 : ceil(13/10.0) * 10 => 2 * 10 = 20까지
		// 11 12 13 14 15 16 17 18 19 20

		this.startPage = this.endPage - 9;

		// Total을 통한 endPage재계산
		// 10개씩 보여주는 경우 전체 데이터 수가 80개라고 가정하면 끝번호는 10아닌 8이됨
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		if (realEnd <= this.endPage) {
			this.endPage = realEnd;
		}

		// 시작번호가 1보다 큰 경우 존재
		// => 만약 1~10페이지를 출력할 때는 좌측의 '<<'버튼 생략
		this.pre = this.startPage > 1;

		// realEnd가 끝번호(endPage)보다 큰 경우에만 존재
		// => 총 100페이지, 출력하는 페이지가 90~100일때 우측의 '>>'버튼 생략
		this.next = this.endPage < realEnd;

	}

	public String makeQuery(int page) { // get방식의 URI를 만들어주는 메소드

		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) // pageNum =
																											// 3
				.queryParam("amount", cri.getAmount()) // pageNum 3 * amount 10
				.build(); // ?pageNum=3&amount=10 이렇게 uri넘길수있도록.

		return uriComponentsBuilder.toUriString();
		// ?pageNum=3&amount=10 리턴
	}

}
