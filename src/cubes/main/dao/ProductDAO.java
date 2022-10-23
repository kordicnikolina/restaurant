package cubes.main.dao;

import java.util.List;

import cubes.main.entity.Product;

public interface ProductDAO {
	
	public List<Product> getProductList();
	
	public void saveProduct(Product product);
	
    public void delete(int id);
    
    public Product getProduct(int id);
    
    public Product getProductWithTags(int id);
    
    public List<Product>getProductListByCategory(int id);
    
    public List<Product>getProductListByTag(int id);
    
    public List<Product> getProductList(int orderBy);
}
