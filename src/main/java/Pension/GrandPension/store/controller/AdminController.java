package Pension.GrandPension.store.controller;

import Pension.GrandPension.board.dto.Board;
import Pension.GrandPension.board.dto.Page;
import Pension.GrandPension.store.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

     @Autowired
     AdminService adminService;

    // 관리자화면 조회
    @GetMapping("/index")
    public void getIndex() throws Exception {

    }

    // 상품 등록 페이지
    @GetMapping("/goods/register")
    public void getGoodsRegister(Model model) throws Exception {

        List<CategoryVO> category = null;
        category = adminService.category();
        model.addAttribute("category", JSONArray.fromObject(category));
    }

    // 상품 등록
    @PostMapping("/goods/register")
    public String postGoodsRegister(GoodsVO vo) throws Exception {

        adminService.register(vo);

        return "redirect:/admin/index";
    }

    // 상품 목록
    @GetMapping("/goods/list")
    public void getGoodsList(Model model) throws Exception {

        List<GoodsVO> list = adminService.goodslist();

        model.addAttribute("list", list);
    }

    // 상품 조회
    @GetMapping ("/goods/view")
    public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception {

        GoodsVO goods = adminService.goodsView(gdsNum);

        model.addAttribute("goods", goods);
    }


}
