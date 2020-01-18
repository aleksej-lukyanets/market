package market.service;

import market.domain.Distillery;
import market.domain.Product;
import market.domain.Region;
import market.exception.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Сервис товаров.
 */
public interface ProductService {

	void save(Product product);

	void delete(Product product);

	Product findOne(long productId) throws ProductNotFoundException;

	List<Product> findAllOrderById();

	Page<Product> findAll(PageRequest request);

	List<Product> findByDistillery(Distillery distillery);

	Page<Product> findByDistillery(Distillery distillery, Pageable pageable);

	Page<Product> findByDistilleriesOfRegion(Region region, Pageable pageable);
}
