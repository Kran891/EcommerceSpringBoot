package com.kran.commerce.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kran.commerce.DAO.interfaces.IProductDAO;
import com.kran.commerce.entities.Product;
import com.kran.commerce.errors.ServiceError;
import com.kran.commerce.services.interfaces.IProductService;

import jakarta.transaction.Transactional;

@Service
public class ProductService implements IProductService{
    private final IProductDAO productDAO;
    @Autowired
    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    
    
    @Override
    @Transactional
    public Product Save(Product product) {
        return productDAO.Save(product);
    }

    @Override
    @Transactional
    public void Delete(int id) {
        int res=productDAO.Delete(id);
        if (res==0) {
            throw new ServiceError("No Product was Found with Id- "+id);
        }
    }

    @Override
    @Transactional
    public Product Update(Product product) {
        return productDAO.Update(product);
    }

    @Override
    public List<Product> FindByCategory(int cId) {
        List<Product> products=productDAO.FindByCategory(cId);
        if(products==null){
            throw new ServiceError("No Products Found with CategoryId- "+cId);
        }
        return products;
    }

    @Override
    public Product FindById(int id) {
        Product product=productDAO.FindById(id);
        if(product==null){
            throw new ServiceError("No Product Found with Id- "+id); 
        }
        return product;
    }

    @Override
    public void GroupByCategories() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
