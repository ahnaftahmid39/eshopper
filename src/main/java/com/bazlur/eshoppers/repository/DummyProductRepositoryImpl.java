package com.bazlur.eshoppers.repository;

import java.math.BigDecimal;
import java.util.List;

import com.bazlur.eshoppers.dto.ProductDTO;

public class DummyProductRepositoryImpl implements ProductRepository {

  @Override
  public List<ProductDTO> findAllProducts() {
    return List.of(
        new ProductDTO("Apple Ipad", "Apple Ipad 10.2 32GB", BigDecimal.valueOf(369.99)),
        new ProductDTO("Headphones", "Bluetooth headphone", BigDecimal.valueOf(29.99)),
        new ProductDTO("Keyboard", "TRI, Gasket mounted RGB", BigDecimal.valueOf(59.99)));
  }

}
