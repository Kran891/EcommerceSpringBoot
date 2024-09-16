package com.kran.commerce.DAO.classes;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kran.commerce.DAO.interfaces.IProductDAO;
import com.kran.commerce.entities.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class ProductDAO implements  IProductDAO{
   private final EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void Save(Product product) {
          entityManager.persist(product);
        }

    @Override
    public void Delete(int id) {
        entityManager.remove(FindById(id));
      }

    @Override
    public void Update(Product product) {
        entityManager.merge(product);
        }

    @Override
    public List<Product> FindByCategory(int cId) {
        TypedQuery<Product> query=entityManager.createQuery("FROM Product where categoryId=:cId",Product.class);
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
