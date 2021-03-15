package Pension.GrandPension.board.mapper;

import Pension.GrandPension.board.dto.Board;
import Pension.GrandPension.board.dto.Page;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글 목록 조회
    public List<Board> list() throws Exception;

    //게시글 생성
    public void create(Board board) throws Exception;

    //게시글 읽기
    public Board read(Integer boardNo) throws Exception;

    //게시글 수정
    public void update(Board board) throws Exception;

    //게시글 삭제
    public void delete(Integer boardNo) throws Exception;

    //게시글 서치
    public List<Board> search(String keyword) throws Exception;

    //전체 게시물
    public Integer totalRows() throws Exception;

    // [페이지] 게시글 목록 조회
    public List<Board> listWithPage(Page page) throws Exception;

}
