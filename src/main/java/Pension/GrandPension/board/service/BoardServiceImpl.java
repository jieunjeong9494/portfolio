package Pension.GrandPension.board.service;

import Pension.GrandPension.board.dto.Board;
import Pension.GrandPension.board.dto.Page;
import Pension.GrandPension.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper mapper;


    //게시글 목록 조회
    @Override
    public List<Board> list() throws Exception {
        return mapper.list();
    }

    //게시글 쓰기
    @Override
    public void register(Board board) throws Exception {
        System.out.println("@BoardSeviceImpl :");
        System.out.println(board.toString());
        mapper.create(board);
    }

    //게시글 읽기
    //1.여기서 read?board_no를 통해 가져오기 떄문에 이쪽에서 에러페이지 처리를 만들어준다.
    //mapper는 데이터가 없을때 항상 null 근데 repository쪽은 optional 임
    //데이터가 없어도 null이 안됌 ! null.exception (즉 , repository는 null이 발생 안함)
    @Override
    public Board read(Integer boardNo) throws Exception {

        //이렇게 하면 db에서 가져온 값이 board에 들어감 . .
        Board board = mapper.read(boardNo);
        //==똑같은지 확인하는 기호
        if(board == null){
            throw new IllegalArgumentException("해당 내용이 없습니다");
        }
            return board;

      //  return mapper.read(boardNo); 이미 위에 만들어놔서
    }

    //게시글 수정
    @Override
    public void modify(Board board) throws Exception {
        mapper.update(board);
    }

    //게시글 삭제
    @Override
    public void remove(Integer boardNo) throws Exception {
        mapper.delete(boardNo);
    }

    //게시글 찾기
    @Override
    public List<Board> search(String keyword) throws Exception {
        return mapper.search(keyword);
    }

    @Override
    public Integer totalRows() throws Exception {
        return mapper.totalRows();
    }

    @Override
    public List<Board> list(Page page) throws Exception {
        return mapper.listWithPage(page);
    }

    //왜 list(page)라고 안함? -> 목록 조회할 떄 , id값으로 list를 해놨기 떄문이다.

}
