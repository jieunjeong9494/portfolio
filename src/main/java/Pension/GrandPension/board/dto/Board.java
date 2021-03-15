package Pension.GrandPension.board.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Data //@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Board {
    //form의 input name명이랑 동일
    private int rowNo;
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private String imageName;

    // 이미지 업로드 후, 파일명 저장
    public void uploadImage(MultipartFile files, String uploadPath) throws IOException {
        UUID uuid = UUID.randomUUID(); // 랜덤 난수 생성 -> 손님이 같은 파일명 겹치치 않도록
        //업로드 될 파일저장
        //String filename = uuid.toString();
        String filename = uuid.toString() + "_" + files.getOriginalFilename();

        //경로 설정 (절대 경로) 파일경로 + (/라는 뜻) + 파일명
        String filePath = uploadPath + File.separator + filename;
        //File 이라는 객체를 생성하여 , 파일 경로를 받아옴 (받은 이미지를 쓰기 위해)
        File file = new File(filePath);
        // transferTo 기본메소드를 통해, 파일 경로(절대경로)에 집어넣기
        files.transferTo(file);
        //업로드된 파일명을 imageName에 저장시킴
        this.imageName = filename;
    }
}
