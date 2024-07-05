package com.sansilvestre.desktop.app.sale.data.repository;

import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.sale.data.source.SaleStorage;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.sale.domain.repository.SaleRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.log.Console;

import java.util.List;

public class SaleRepositoryImplementation implements SaleRepository {

    private final SaleStorage storage;

    public SaleRepositoryImplementation(SaleStorage storage) {
        this.storage = storage;
    }

    @Override
    public Response<List<Sale>> getSaleList() {
        Response<List<Sale>> getSaleList = storage.getSaleList();
        getSaleList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Sale>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetSaleList");
            }

            @Override
            public void visitFailure(Response.Failure<List<Sale>> failure) {
                Console.warn(Console.WarnCode.W001, "Error: GetSaleList");
            }

        });
        return getSaleList;
    }

    @Override
    public Response<List<Sale>> getSaleListByBranchID(int branchId) {
        Response<List<Sale>> getSaleList = storage.getSaleListByBranchId(branchId);
        getSaleList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Sale>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetSaleList by Branch ID - " + branchId);
            }

            @Override
            public void visitFailure(Response.Failure<List<Sale>> failure) {
                Console.warn(Console.WarnCode.W001, "Error: GetSaleList by Branch ID - " + branchId);
            }

        });
        return getSaleList;
    }

    @Override
    public Response<List<Item>> getSaleItemListBySaleID(int saleId) {
        Response<List<Item>> getSaleList = storage.getSaleItemListBySaleID(saleId);
        getSaleList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Item>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetItemList by Sale ID - " + saleId);
            }

            @Override
            public void visitFailure(Response.Failure<List<Item>> failure) {
                Console.warn(Console.WarnCode.W001, "Error: GetItemList by Sale ID - " + saleId);
            }

        });
        return getSaleList;
    }

    @Override
    public Response<Void> addSale(Sale sale) {
        Response<Integer> addSale = storage.addSale(sale);
        final Response<Void>[] state = new Response[] { null };
        addSale.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Integer> success) {
                sale.getItemList().forEach(item -> {
                    item.setSaleId(success.getObject());
                    Response<Void> addItem = storage.addSaleItem(item);
                    addItem.accept(new ResponseVisitor<>() {

                        @Override
                        public void visitSuccess(Response.Success<Void> success) {
                            Response<Void> updateProductStock = storage.updateProductStockByItemUnits(item.getUnits(), item.getBarcode());
                            updateProductStock.accept(new ResponseVisitor<>() {

                                @Override
                                public void visitSuccess(Response.Success<Void> success) {
                                    Console.info(Console.InfoCode.I001, "OK: UpdateProductStock by ItemUnits - " + item.getBarcode());
                                    state[0] = new Response.Success<>(null);
                                }

                                @Override
                                public void visitFailure(Response.Failure<Void> failure) {
                                    Console.warn(Console.WarnCode.W001, "ERROR: UpdateProductStock by ItemUnits - " + item.getBarcode());
                                    state[0] = new Response.Failure<>(failure.getException());
                                }

                            });
                        }

                        @Override
                        public void visitFailure(Response.Failure<Void> failure) {
                            state[0] = new Response.Failure<>(failure.getException());
                        }

                    });
                });
            }

            @Override
            public void visitFailure(Response.Failure<Integer> failure) {
                Console.warn(Console.WarnCode.W001, "Error: AddSale");
                state[0] = new Response.Failure<>(failure.getException());
            }

        });
        return state[0];
    }
}