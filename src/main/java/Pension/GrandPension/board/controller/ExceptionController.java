package Pension.GrandPension.board.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("Pension.GrandPension.board.controller.BoardController")
public class ExceptionController {

    //IllegalArgumentException발생하면 notFound메소드 실행
    @ExceptionHandler(IllegalArgumentException.class)
    public String notFound(Exception exception, Model model){

        //타임리프는 exception안에 메시지가 있는지 모른다.
        model.addAttribute("message",exception.getMessage());

        return "error";

    }
}
