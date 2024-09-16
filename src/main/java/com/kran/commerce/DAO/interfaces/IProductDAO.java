package com.kran.commerce.DAO.interfaces;

import java.util.List;

import com.kran.commerce.entities.Product;

public interface IProductDAO {
  void Save(Product product);
  void Delete(int id);
  void Update(Product product);
  List<Product> FindByCategory(int cId);
  Product FindById(int id);
  void GroupByCategories();
}
