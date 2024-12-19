package com.kosea.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosea.project.dao.CartDAO;
import com.kosea.project.vo.CartVO;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;

    @Override
    public List<CartVO> getCartItems(String userId) {
        return cartDAO.getCartItems(userId);
    }

    @Override
    public void addItemToCart(String userId, String productId, int quantity) {
        cartDAO.addItemToCart(userId, productId, quantity);
    }

    @Override
    public void updateItemQuantity(int cartId, int quantity) {
        cartDAO.updateItemQuantity(cartId, quantity);
    }

    @Override
    public void removeItemFromCart(int cartId) {
        cartDAO.removeItemFromCart(cartId);
    }

    @Override
    public void clearCart(String userId) {
        cartDAO.clearCart(userId);
    }

    @Override
    public void purchaseItems(String userId) {
        cartDAO.purchaseItems(userId);
    }
}
