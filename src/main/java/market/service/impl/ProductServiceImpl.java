package market.service.impl;

import market.dao.ProductDAO;
import market.domain.Distillery;
import market.domain.Product;
import market.domain.Region;
import market.exception.ProductNotFoundException;
import market.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация сервиса товара.
 */
public class ProductServiceImpl implements ProductService {
	private final ProductDAO productDAO;

	public ProductServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Transactional
	@Override
	public void save(Product product) {
		productDAO.save(product);
	}

	@Transactional
	@Override
	public void delete(Product product) {
		productDAO.delete(product);
	}

	@Transactional(readOnly = true)
	@Override
	public Product findOne(long productId) throws ProductNotFoundException {
		Product product = productDAO.findOne(productId);
		if (product == null) {
			throw new ProductNotFoundException();
		}
		return product;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Product> findAllOrderById() {
		return productDAO.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Product> findAll(PageRequest request) {
		return productDAO.findAll(request);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Product> findByDistillery(Distillery distillery) {
		return productDAO.findByDistillery(distillery);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Product> findByDistillery(Distillery distillery, Pageable pageable) {
		return productDAO.findByDistillery(distillery, pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Product> findByDistilleriesOfRegion(Region region, Pageable pageable) {
		return productDAO.findByDistilleriesOfRegion(region, pageable);
	}
}
