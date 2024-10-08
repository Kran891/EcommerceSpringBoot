package com.kran.commerce.DAO.interfaces;

import java.util.List;

import com.kran.commerce.entities.Product;

public interface IProductDAO {
  Product Save(Product product);
  int Delete(int id);
  Product Update(Product product);
  List<Product> FindByCategory(int cId);
  Product FindById(int id);
  void GroupByCategories();
}
