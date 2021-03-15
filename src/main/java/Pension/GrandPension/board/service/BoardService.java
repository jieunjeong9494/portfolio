package Pension.GrandPension.board.service;

import Pension.GrandPension.board.dto.Board;
import Pension.GrandPension.board.dto.Page;
import org.springframework.stereotype.Service;
import java.util.List;

public interface BoardService {

    //게시글 목록보기
    public List<Board> list() throws Exception;

    //게시글 생성 c
    public void register(Board board) throws Exception;

    //게시글 읽기 r
    public Board read(Integer boardNo) throws Exception;

    //게시글 수정 u
    public void modify(Board board) throws Exception;

    //게시글 삭제 d
    public void remove(Integer boardNo) throws Exception;

    //게시글 목록 검색
    public List<Board> search(String keyword) throws Exception;

    //전체 게시글 수
    public Integer totalRows() throws Exception;

    //페이지 리스트 조회
    public List<Board> list(Page page) throws Exception;

}
