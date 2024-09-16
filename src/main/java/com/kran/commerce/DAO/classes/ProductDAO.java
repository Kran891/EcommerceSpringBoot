package com.kran.commerce.DAO.classes;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kran.commerce.DAO.interfaces.IProductDAO;
import com.kran.commerce.entities.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
@Repository
public class ProductDAO implements  IProductDAO{
   private final EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Product Save(Product product) {
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
        TypedQuery<Product> query=entityManager.createQuery("FROM Product where categoryId=:cId",Product.class);
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
