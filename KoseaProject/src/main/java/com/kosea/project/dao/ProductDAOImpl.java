package com.kosea.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosea.project.vo.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "com.kosea.project.mappers.ProductMapper";

    @Override
    public void addProduct(ProductVO product) throws Exception {
        sqlSession.insert(namespace + ".addProduct", product);
    }

    @Override
    public void updateProduct(ProductVO product) throws Exception {
        sqlSession.update(namespace + ".updateProduct", product);
    }

    @Override
    public void deleteProduct(int productId) throws Exception {
        sqlSession.delete(namespace + ".deleteProduct", productId);
    }

    @Override
    public List<ProductVO> getProductList() throws Exception {
        return sqlSession.selectList(namespace + ".getProductList");
    }

    @Override
    public ProductVO getProductById(int productId) throws Exception {
        return sqlSession.selectOne(namespace + ".getProductById", productId);
    }
}
