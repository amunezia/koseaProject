package com.kosea.project.dao;

import java.util.List;

import com.kosea.project.vo.CartVO;

public interface CartDAO {

    List<CartVO> getCartItems(String userId);

    void addItemToCart(String userId, String productId, int quantity);

    void updateItemQuantity(int cartId, int quantity);

    void removeItemFromCart(int cartId);

    void clearCart(String userId);

    void purchaseItems(String userId);
}
