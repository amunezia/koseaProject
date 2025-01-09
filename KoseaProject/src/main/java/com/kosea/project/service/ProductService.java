package com.kosea.project.service;

import java.util.List;

import com.kosea.project.vo.ProductVO;

public interface ProductService {
    void addProduct(ProductVO product) throws Exception;  // 商品追加

    void updateProduct(ProductVO product) throws Exception;  // 商品更新

    void deleteProduct(int productId) throws Exception;  // 商品削除

    List<ProductVO> getProductList() throws Exception;  // 商品一覧取得

    ProductVO getProductById(int productId) throws Exception;  // 商品IDで商品取得
}
