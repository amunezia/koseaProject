package com.kosea.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosea.project.dao.ProductDAO;
import com.kosea.project.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void addProduct(ProductVO product) throws Exception {
        productDAO.addProduct(product);
    }

    @Override
    public void updateProduct(ProductVO product) throws Exception {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) throws Exception {
        productDAO.deleteProduct(productId);
    }

    @Override
    public List<ProductVO> getProductList() throws Exception {
        return productDAO.getProductList();
    }

    @Override
    public ProductVO getProductById(int productId) throws Exception {
        return productDAO.getProductById(productId);
    }
}
