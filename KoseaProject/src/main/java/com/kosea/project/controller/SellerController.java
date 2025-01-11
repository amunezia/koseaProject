package com.kosea.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosea.project.service.ProductService;
import com.kosea.project.vo.ProductVO;

@Controller
@RequestMapping("/seller/*")
public class SellerController {
    
    @Autowired
    private ProductService productService;

    // 販売者ページ
    @GetMapping("/sellerPage")
    public String sellerPage() {
        return "seller/sellerPage";  
    }

    // 商品登録ページ
    @GetMapping("/productRegister")
    public String productRegister() {
        return "seller/productRegister";
    }

    @GetMapping("/productList")
    public String getProductList(Model model) throws Exception {
        List<ProductVO> productList = productService.getProductList();
        model.addAttribute("productList", productList); // ここでセット
        // ログに出力
        System.out.println("商品リスト: " + productList);
        return "seller/productList"; // 商品リストページ
    }

    // 商品登録処理
    @PostMapping("/registerProduct")
    public String registerProduct(ProductVO product) throws Exception {
        // 商品をデータベースに登録
        productService.addProduct(product);
        return "redirect:/seller/productList";  // 商品リストページにリダイレクト
    }

    // 売上データページ
    @GetMapping("/salesData")
    public String salesData() {
        return "seller/salesData";
    }
}
