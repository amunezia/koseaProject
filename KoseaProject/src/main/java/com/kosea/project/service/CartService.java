package com.kosea.project.service;

import java.util.List;

import com.kosea.project.vo.CartVO;

public interface CartService {

    List<CartVO> getCartItems(String userId);

    void addItemToCart(String userId, String productId, int quantity);

    void updateItemQuantity(int cartId, int quantity);

    void removeItemFromCart(int cartId);

    void clearCart(String userId);

    void purchaseItems(String userId);
}
