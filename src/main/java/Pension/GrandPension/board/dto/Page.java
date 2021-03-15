package Pension.GrandPension.board.dto;

import lombok.Data;

@Data
public class Page{
    //필수
    //현재 페이지 번호
    private int pageNum;
    //페이지 당 보여줄 게시물 수
    private int rowsPerPage;
    //노출 페이지 수
    private int pageCount;
    //전체 게시글 데이터 수
    private int totalRows;

    //계산
    //첫번째 페이지
    private int startPage;
    //마지막 페이지
    private int endPage;

    //무조건 첫번쨰 페이지
    private int firstPage;
    //무조건 마지막 페이지
    private int lastPage;

    //이전 페이지
    private int prev;
    //다음 페이지
    private int next;

    //시작글 index
    private int startRowIndex;

    //스프링부트가 page라는 객체를 만들 떄, 스프링부트는 pagenum이나 rowsperpage같은 숫자를 모름
    //41번줄에 있는걸 , 스프링은 뭔지 모름 ... 파라메터가 없는 생성자를 전에 미리 만들어준다
    public Page(){} // default 라는게 있는데 int라면 다 0 ... 1.디폴트 만든 후에 41번줄 처럼 셋팅해준다

    //다른 class에서 생성자들을 쓰니까 public 에서 씀
    public Page(int pageNum, int rowsPerPage, int pageCount, int totalRows ){

        this.pageNum = pageNum;
        this.rowsPerPage = rowsPerPage;
        this.pageCount = pageCount;
        this.totalRows = totalRows;

        //계산식
        this.prev = pageNum -1;
        this.next = pageNum +1;
        //내가 있는 부분에서 전체 부분을 나누어 주면 남는게 떨어져나감
        //앞에 있는게 안으로 들어간다.. 나누기의
        this.startPage = ((pageNum-1)/pageCount)*pageCount + 1;
        this.endPage =((pageNum-1)/pageCount+1)*pageCount;

        this.firstPage = 1;

        //현재 페이지를 생각하지 않음. 전체 페이지랑 보여주는 페이지만 보여줌
        if (totalRows % rowsPerPage == 0)
            this.lastPage = totalRows/rowsPerPage;
        else
            this.lastPage = totalRows/rowsPerPage + 1;

        // endPage는 현재 페이지랑 노출 페이지 무조건 10 !!!!
        // 내가 있는 페이지는 16 전체 페이지는 19
        //원래는 20이 되야되는데,,,, 마지막 게시글이 19떄는 , 같아야함 20이 되면 안됌
        if(this.endPage>this.lastPage)
            this.endPage = this.lastPage;


        //페이지에서 첫번째 숫자(내부적인거임).. 쓰는 이유 아직 모름 ///
        this.startRowIndex = (pageNum-1)*rowsPerPage;



    }



}