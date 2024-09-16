package com.kran.commerce.DAO.classes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kran.commerce.DAO.interfaces.ICategoryDAO;
import com.kran.commerce.DAO.interfaces.IProductDAO;
import com.kran.commerce.entities.Category;
import com.kran.commerce.entities.Product;
import com.kran.commerce.errors.ServiceError;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
@Repository
public class ProductDAO implements  IProductDAO{
   private final EntityManager entityManager;
    private final ICategoryDAO categoryDAO;

    public ProductDAO(EntityManager entityManager,ICategoryDAO categoryDAO) {
        this.categoryDAO=categoryDAO;
        this.entityManager = entityManager;
    }

    @Override
    public Product Save(Product product) {
       Optional<Category> category = categoryDAO.findById(product.categoryId);
        if(category.isEmpty()){
            throw new ServiceError("Please Check the CategoryId Provided ");
        }
        product.setCategory(category.get());
          entityManager.persist(product);
          return product;
        }

    @Override
    public int Delete(int id) {
        //This way is possible but alt way is good
        Query query=entityManager.createQuery("DELETE FROM Product where id=:id");
        query.setParameter("id", id);
        return query.executeUpdate();
       // entityManager.remove(FindById(id));
      }

    @Override
    public Product Update(Product product) {
        return entityManager.merge(product);
        }

    @Override
    public List<Product> FindByCategory(int cId) {
        TypedQuery<Product> query=entityManager.createQuery("FROM Product where category.id=:cId",Product.class);
        query.setParameter("cId", cId);
        return query.getResultList(); 
    }

    @Override
    public Product FindById(int id) {
        return entityManager.find(Product.class, id);
     }

    @Override
    public void GroupByCategories() {
        
    }

}
