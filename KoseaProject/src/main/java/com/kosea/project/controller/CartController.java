package com.kosea.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosea.project.service.CartService;
import com.kosea.project.vo.CartVO;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // カートを表示
    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";  // ログインしていない場合、ログイン画面へリダイレクト
        }

        List<CartVO> cartList = cartService.getCartItems(userId);
        model.addAttribute("cartList", cartList);
        return "cart/cart";  // cart.jspを表示
    }

    // カートに商品を追加
    @PostMapping("/add")
    public String addToCart(HttpSession session, 
                            @RequestParam("productId") String productId, 
                            @RequestParam("quantity") int quantity) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/users/signin";  // ログインしていない場合、ログイン画面へリダイレクト
        }

        // カートに商品を追加する
        cartService.addItemToCart(userId, productId, quantity);
        return "redirect:/cart/view";  // カートの内容を表示するページにリダイレクト
    }

    // カート内の数量を変更
    @PostMapping("/update")
    public String updateCartQuantity(HttpSession session, 
                                     @RequestParam("cartId") int cartId, 
                                     @RequestParam("quantity") int quantity) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";  // ログインしていない場合、ログイン画面へリダイレクト
        }

        cartService.updateItemQuantity(cartId, quantity);  // 数量変更処理
        return "redirect:/cart/view";  // カートの内容を表示するページにリダイレクト
    }

    // カートから商品を削除
    @PostMapping("/remove")
    public String removeFromCart(HttpSession session, @RequestParam("cartId") int cartId) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";  // ログインしていない場合、ログイン画面へリダイレクト
        }

        cartService.removeItemFromCart(cartId);  // 商品削除処理
        return "redirect:/cart/view";  // カートの内容を表示するページにリダイレクト
    }

    // カート内をクリア
    @PostMapping("/clear")
    public String clearCart(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";  // ログインしていない場合、ログイン画面へリダイレクト
        }

        cartService.clearCart(userId);  // カートクリア処理
        return "redirect:/cart/view";  // カートの内容を表示するページにリダイレクト
    }

    // 購入処理
    @PostMapping("/purchase")
    public String purchaseItems(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";  // ログインしていない場合、ログイン画面へリダイレクト
        }

        cartService.purchaseItems(userId);  // 購入処理
        return "redirect:/cart/view";  // カートの内容を表示するページにリダイレクト
    }
}
