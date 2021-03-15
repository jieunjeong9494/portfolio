package Pension.GrandPension;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {

    @GetMapping("/grandpension")
    public String main(){

        return "index";
    }


 @GetMapping("/grandpanesion/error")
 public String error(){

        return "error";
    }

}
