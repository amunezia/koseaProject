package com.kosea.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosea.project.vo.CartVO;

@Repository
public class CartDAOImpl implements CartDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.kosea.project.mapper.CartMapper";

    @Override
    public List<CartVO> getCartItems(String userId) {
        return sqlSession.selectList(NAMESPACE + ".getCartItems", userId);
    }

    @Override
    public void addItemToCart(String userId, String productId, int quantity) {
        CartVO cartVO = new CartVO();
        cartVO.setUserId(userId);
        cartVO.setProductId(productId);
        cartVO.setQuantity(quantity);
        sqlSession.insert(NAMESPACE + ".addItemToCart", cartVO);
    }

    @Override
    public void updateItemQuantity(int cartId, int quantity) {
        CartVO cartVO = new CartVO();
        cartVO.setCartId(cartId);
        cartVO.setQuantity(quantity);
        sqlSession.update(NAMESPACE + ".updateItemQuantity", cartVO);
    }

    @Override
    public void removeItemFromCart(int cartId) {
        sqlSession.delete(NAMESPACE + ".removeItemFromCart", cartId);
    }

    @Override
    public void clearCart(String userId) {
        sqlSession.delete(NAMESPACE + ".clearCart", userId);
    }

    @Override
    public void purchaseItems(String userId) {
        sqlSession.update(NAMESPACE + ".purchaseItems", userId);
    }
}
