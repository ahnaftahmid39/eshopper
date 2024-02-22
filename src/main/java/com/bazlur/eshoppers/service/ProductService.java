package com.bazlur.eshoppers.service;

import java.util.List;

import com.bazlur.eshoppers.dto.ProductDTO;

public interface ProductService {
  public List<ProductDTO> findAllProductSortedByName();
}