package com.kran.commerce.services.interfaces;



import java.util.List;

import com.kran.commerce.entities.Product;

public interface IProductService {
  Product Save(Product product);
  void Delete(int id);
  Product Update(Product product);
  List<Product> FindByCategory(int cId);
  Product FindById(int id);
  void GroupByCategories();
}
