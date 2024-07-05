package com.sansilvestre.desktop.app.sale.data.source;

import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.product.data.source.ProductQuery;
import com.sansilvestre.desktop.app.util.exception.ProductNotUpdatedException;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.sale.domain.util.structure.ItemList;
import com.sansilvestre.desktop.app.sale.domain.util.structure.SaleList;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotAddedException;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.sql.*;
import java.util.List;

public class SaleStorage {

    public Response<List<Sale>> getSaleList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SaleQuery.GET_SALES)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(SaleList.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Sale>> getSaleListByBranchId(int branchId) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SaleQuery.GET_SALES_BY_BRANCH_ID)) {
                statement.setInt(1, branchId);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(SaleList.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Item>> getSaleItemListBySaleID(int saleId) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SaleQuery.GET_SALE_ITEMS_BY_SALE_ID)) {
                statement.setInt(1, saleId);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(ItemList.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Integer> addSale(Sale sale) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SaleQuery.ADD_SALE, Statement.RETURN_GENERATED_KEYS)) {
                sale.populateStatement(statement);
                if (statement.executeUpdate() > 0)
                    try (ResultSet result = statement.getGeneratedKeys()) {
                        if (result.next()) {
                            return new Response.Success<>(result.getInt(1));
                        } else {
                            throw new UserNotAddedException();
                        }
                    }
                else
                    throw new UserNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addSaleItem(Item item) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SaleQuery.ADD_SALE_ITEM)) {
                item.populateStatement(statement);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }



    public Response<Void> updateProductStockByItemUnits(int units, String barcode) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT_STOCK_BY_ITEM_UNITS)) {
                statement.setInt(1, units);
                statement.setString(2, barcode);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}