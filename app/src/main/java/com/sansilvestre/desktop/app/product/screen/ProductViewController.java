package com.sansilvestre.desktop.app.product.screen;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.product.domain.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductViewController {

    void initializeListeners();

    void setProductList(List<Product> products);

    void setCategoryMap(Map<Integer, Category> categories);
    void setBranchMap(Map<Integer, Branch> branches);

    void refresh();

}