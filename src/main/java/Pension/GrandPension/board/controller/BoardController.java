package Pension.GrandPension.board.controller;

import Pension.GrandPension.board.dto.Board;
import Pension.GrandPension.board.dto.Page;
import Pension.GrandPension.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//요청받는 메소드속성이 없음,공통된거

@Controller
@RequestMapping("/board")
public class BoardController {


    @Autowired
    private BoardService service;

    // 게시글 목록 조회 서비스 메소드 호출 ,, db에서 board를 가져옴
    @GetMapping("/list")
    public void list(Model model, Page page) throws Exception{

       Integer totalRows = service.totalRows();
       //변경한 페이지가 다르기 떄문에 이름다름
       Page newPage;
       //객체 생성이 안됬을 때, 밖에서 리스트 들어갔을 때, 1부터 시작함
       if( page.getPageNum() == 0)
          newPage =  new Page(1,15,10,totalRows);
       else
           //만약 3페이지 들어갔을 때, 3페이지를 기준으로 계속 불러옴
           newPage = new Page(page.getPageNum(),15,10,totalRows);

        List<Board> boardList = service.list(newPage);

        model.addAttribute("list", boardList);
        model.addAttribute("page", newPage);


////      List<Board> boardList = service.list();
//        model.addAttribute("list",boardList);

    }



    //글쓰기 요청 화면
    @GetMapping("/register")
    public void registerForm(Model model, Board board){
        //return "board/register";
    }

    //글쓰기 과정 , 파일 업로드 시작
    @PostMapping("/register")
    //input name = "image" 에 있던거 가져온거임
    //mulipartfile -> 안에 업로드된 파일 내용이 들어있음
    public String register(@RequestParam("image") MultipartFile files,
            Model model, Board board) throws Exception{
        //업로드한 이미지를 보여주는 설정을 해야함 (static파일)
        //스프링부트에서 페이지를 보여줄 떄 자바를 만든 페이지를 보여줌 , static 한 파일을 보여주는 방법


        //1,이미지 경로 설정
        String uploadPath = "C:\\PENSION_BOARD_IMG";
        //2. 받은 이미지들과 경로를 가지고 uploadImage 메소드를 실행 (board)에 내가 만든 메소드
        board.uploadImage(files, uploadPath);


        service.register(board);
        model.addAttribute("msg","등록이 완료되었습니다!");
        return "board/success";
    }

    //게시글 읽기 화면
    @GetMapping("/read")
    public void read(Model model, Integer boardNo) throws Exception{
        //기본값으로 반환완료함 (board)
        model.addAttribute(service.read(boardNo));
        //Board board
    }

    //게시글 수정 화면
    @GetMapping("/modify")
    public void modify(Model model, Integer boardNo) throws Exception{
        model.addAttribute(service.read(boardNo));
    }

    //게시글 수정 처리
    @PostMapping("/modify")
    public String modify(@RequestParam("image") MultipartFile files,Model model, Board board) throws Exception{


        //1,이미지 경로 설정
        String uploadPath = "C:\\PENSION_BOARD_IMG";
        //2. 받은 이미지들과 경로를 가지고 uploadImage 메소드를 실행 (board)에 내가 만든 메소드
        board.uploadImage(files, uploadPath);

        service.modify(board);
        model.addAttribute("msg","수정이 완료되었습니다");
        return "board/success";

    }

    //게시글 삭제
    @PostMapping("/remove")
    public String remove(Model model,Integer boardNo) throws Exception{
        service.remove(boardNo);
        model.addAttribute("msg","삭제가 완료되었습니다");
        return "board/success";

    }


    // 게시글 검색
    @PostMapping("/search")
    public String search(String keyword, Model model) throws Exception {

        model.addAttribute("list", service.search(keyword) );

        return "board/list";
    }

}
