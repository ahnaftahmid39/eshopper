package com.bazlur.eshoppers.repository;

import java.util.List;
import com.bazlur.eshoppers.dto.ProductDTO;

public interface ProductRepository {
  public List<ProductDTO> findAllProducts();
}
