package com.sansilvestre.desktop.app.product.data.source;

import com.sansilvestre.desktop.app.product.domain.util.structure.ProductList;
import com.sansilvestre.desktop.app.product.domain.util.structure.ProductMap;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.domain.util.exception.*;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.exception.ProductNotAddedException;
import com.sansilvestre.desktop.app.util.exception.ProductNotUpdatedException;
import com.sansilvestre.desktop.app.util.objects.Stock;
import com.sansilvestre.desktop.app.util.parser.Search;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ProductStorage {

    public Response<Product> getProductByBarcode(String barcode) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCT_BY_BARCODE)) {
                statement.setString(1, barcode);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next())
                        return new Response.Success<>(new Product(result));
                    else
                        throw new ProductNotFoundException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Map<String, Product>> getProductMap() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS)) {
                try (ResultSet result = statement.executeQuery()) {
                    Map<String, Product> database = ProductMap.of(result);
                    if (database != null)
                        return new Response.Success<>(database);
                    else
                        throw new ProductNotFoundException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Product>> getProductList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(ProductList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Product>> getProductListBySearch(String search) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS_BY_SEARCH)) {
                Search.ofProduct(statement, search);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(ProductList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Product>> getProductListByStock(Stock stock) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.getGetProductListByStockQuery(stock))) {
                try (ResultSet results = statement.executeQuery()) {
                    return new Response.Success<>(ProductList.of(results));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Product>> getProductListByCategoryID(int categoryId) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS_BY_CATEGORY_ID)) {
                statement.setInt(1, categoryId);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(ProductList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Product>> getProductListByBranchID(int branchId) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS_BY_OFFICE_ID)) {
                statement.setInt(1, branchId);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(ProductList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.INSERT_PRODUCT)) {
                product.populateStatementForAdd(statement);
                if (statement.executeUpdate() > 0) {
                    LocalDateTime timestamp = getStorageTimestamp(product.getBarcode());
                    product.setAddedDate(timestamp);
                    product.setUpdatedDate(timestamp);
                    return new Response.Success<>(null);
                } else {
                    throw new ProductNotAddedException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> syncAddProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SYNC_INSERT_PRODUCT)) {
                product.populateStatementForSyncAdd(statement);
                if (statement.executeUpdate() > 0) {
                    return new Response.Success<>(null);
                } else {
                    throw new ProductNotAddedException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT)) {
                product.populateStatementForUpdate(statement);
                if (statement.executeUpdate() > 0) {
                    LocalDateTime timestamp = getStorageTimestamp(product.getBarcode());
                    product.setUpdatedDate(timestamp);
                    return new Response.Success<>(null);
                } else {
                    throw new ProductNotUpdatedException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> syncUpdateProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SYNC_UPDATE_PRODUCT)) {
                product.populateStatementForSyncUpdate(statement);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProductStockByBarcode(int stock, String barcode) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT)) {
                statement.setInt(1, stock);
                statement.setString(2, barcode);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProductPrice(double increase) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT_PRICES)) {
                statement.setDouble(1, increase);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProductPriceByCategory(double increase, int category) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT_PRICES_BY_CATEGORY)) {
                statement.setDouble(1, increase);
                statement.setInt(2, category);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new CategoryWithoutLinkedProductsException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProductPriceByOffice(double percentage, int office) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT_PRICES_BY_OFFICE)) {
                statement.setDouble(1, percentage);
                statement.setInt(2, office);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new OfficeWithoutLinkedProductsException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> deleteProductByBarcode(String barcode) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.DELETE_PRODUCT)) {
                statement.setString(1, barcode);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotFoundException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }



    public LocalDateTime getStorageTimestamp(String barcode) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_DATABASE_TIMESTAMP)) {
                statement.setString(1, barcode);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        return result.getTimestamp(ProductDatabase.UPDATED_DATE.getColumnName()).toLocalDateTime();
                    } else {
                        throw new Exception();
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

}