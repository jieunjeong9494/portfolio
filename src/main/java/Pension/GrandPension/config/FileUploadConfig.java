package Pension.GrandPension.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//파일 업로드를 관리하는 인터페이스 사용
public class FileUploadConfig implements WebMvcConfigurer {



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //1.경로를 정해줌 -> C드라이브에 직접 만들기
        String uploadPath = "C:\\PENSION_BOARD_IMG";
            //2.read.html의 이미지 url 경로랑 동일
        registry.addResourceHandler("/uploads/**") // 이 URL 패턴 요청 시 이미지 파일명을 통해, 이미지 보여주기
                    //3.C드라이브 경로
                .addResourceLocations("file:///" + uploadPath + "/");
    }



}