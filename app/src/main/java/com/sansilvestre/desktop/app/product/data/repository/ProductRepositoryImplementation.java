package com.sansilvestre.desktop.app.product.data.repository;

import com.sansilvestre.desktop.app.product.data.source.ProductAPI;
import com.sansilvestre.desktop.app.product.data.source.ProductStorage;
import com.sansilvestre.desktop.app.product.data.source.sync.UnsyncedProduct;
import com.sansilvestre.desktop.app.product.data.source.sync.UnsyncedProductStorage;
import com.sansilvestre.desktop.app.util.data.sync.UnsyncedTaskQueue;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.screen.ProductViewController;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.data.sync.AsyncTaskManager;
import com.sansilvestre.desktop.app.util.data.sync.AttemptsManager;
import com.sansilvestre.desktop.app.util.data.sync.UnsyncedTaskType;
import com.sansilvestre.desktop.app.util.log.Console;
import com.sansilvestre.desktop.app.util.objects.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImplementation implements ProductRepository {

    private ProductViewController viewController;

    private final ProductStorage storage;
    private final ProductAPI api;

    private final UnsyncedTaskQueue queue = new UnsyncedTaskQueue();
    private final QueueBackup queueBackup = new QueueBackup();

    private List<UnsyncedProduct> unsyncedProducts = new ArrayList<>();

    private boolean isSync = true;

    private boolean isAdding = false;
    private boolean isUpdating = false;
    private boolean isDeleting = false;

    public ProductRepositoryImplementation(ProductStorage storage, ProductAPI api) {
        this.storage = storage;
        this.api = api;
    }

    @Override
    public void setViewController(ProductViewController viewController) {
        this.viewController = viewController;
    }

    @Override
    public Response<Product> getProductByBarcode(String barcode) {
        Response<Product> getProductByBarcode = storage.getProductByBarcode(barcode);
        getProductByBarcode.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Product> success) {
                Console.info(Console.InfoCode.I001, "OK: GetProductByBarcode");
            }

            @Override
            public void visitFailure(Response.Failure<Product> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: GetProductByBarcode");
            }

        });
        return getProductByBarcode;
    }

    @Override
    public Response<List<Product>> getProductList() {
        Response<List<Product>> getProductList = storage.getProductList();
        getProductList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Product>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetProductList");
            }

            @Override
            public void visitFailure(Response.Failure<List<Product>> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: GetProductList");
            }

        });
        return getProductList;
    }

    @Override
    public Response<List<Product>> getProductListBySearch(String search) {
        Response<List<Product>> getProductList = storage.getProductListBySearch(search);
        getProductList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Product>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetProductList by Search - " + search);
            }

            @Override
            public void visitFailure(Response.Failure<List<Product>> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: GetProductList by Search - " + search);
            }

        });
        return getProductList;
    }

    @Override
    public Response<List<Product>> getProductListByStock(Stock stock) {
        Response<List<Product>> getProductList = storage.getProductListByStock(stock);
        getProductList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Product>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetProductList by Category ID - " + stock);
            }

            @Override
            public void visitFailure(Response.Failure<List<Product>> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: GetProductList by Category ID - " + stock);
            }

        });
        return getProductList;
    }

    @Override
    public Response<List<Product>> getProductListByCategoryID(int categoryId) {
        Response<List<Product>> getProductList = storage.getProductListByCategoryID(categoryId);
        getProductList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Product>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetProductList by Category ID - " + categoryId);
            }

            @Override
            public void visitFailure(Response.Failure<List<Product>> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: GetProductList by Category ID - " + categoryId);
            }

        });
        return getProductList;
    }

    @Override
    public Response<List<Product>> getProductListByBranchID(int branchId) {
        Response<List<Product>> getProductList = storage.getProductListByBranchID(branchId);
        getProductList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Product>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetProductList by BranchID - " + branchId);
            }

            @Override
            public void visitFailure(Response.Failure<List<Product>> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: GetProductList by BranchID - " + branchId);
            }

        });
        return getProductList;
    }

    @Override
    public Response<Void> addProduct(Product product) {
        synchronized (this) {
            isAdding = true;
        }
        Response<Void> addProduct = storage.addProduct(product);
        addProduct.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: AddProduct - " + product.getBarcode());
                viewController.refresh();
                queue.add(() -> syncAddInAPI(product));
                queueBackup.add(new UnsyncedProduct(product.getBarcode(), UnsyncedTaskType.ADD));
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: AddProduct - " + product.getBarcode());
                synchronized (ProductRepositoryImplementation.this) {
                    isAdding = false;
                    resumeSync();
                }
            }

        });
        return addProduct;
    }

    @Override
    public Response<Void> updateProduct(Product product) {
        synchronized (this) {
            isUpdating = true;
        }
        Response<Void> updateProduct = storage.updateProduct(product);
        updateProduct.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: UpdateProduct");
                viewController.refresh();
                queue.add(() -> syncUpdateInAPI(product));
                queueBackup.add(new UnsyncedProduct(product.getBarcode(), UnsyncedTaskType.UPDATE));
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateProduct");
                synchronized (ProductRepositoryImplementation.this) {
                    isUpdating = false;
                    resumeSync();
                }
            }

        });
        return updateProduct;
    }

    @Override
    public Response<Void> updateProductStockByBarcode(int stock, String barcode) {
        synchronized (this) {
            isUpdating = true;
        }
        Response<Void> updateProductStock = storage.updateProductStockByBarcode(stock, barcode);
        updateProductStock.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: UpdateProductStockByBarcode");
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateProductStockByBarcode");
            }

        });
        synchronized (this) {
            isUpdating = false;
            resumeSync();
        }
        return updateProductStock;
    }

    @Override
    public Response<Void> updateProductPriceByBarcode(double increase, String barcode) {
        synchronized (this) {
            isUpdating = true;
        }
        Response<Void> updateProductPrice = storage.updateProductPrice(increase);
        updateProductPrice.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: UpdateProductPriceByBarcode");
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateProductPriceByBarcode");
            }

        });
        synchronized (this) {
            isUpdating = false;
            resumeSync();
        }
        return updateProductPrice;
    }

    @Override
    public Response<Void> updateProductsPricesByCategoryID(double increase, int categoryId) {
        synchronized (this) {
            isUpdating = true;
        }
        Response<Void> updateProductsPrices = storage.updateProductPriceByCategory(increase, categoryId);
        updateProductsPrices.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: UpdateProductsPricesByCategoryID");
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateProductsPricesByCategoryID");
            }

        });
        synchronized (this) {
            isUpdating = false;
            resumeSync();
        }
        return updateProductsPrices;
    }

    @Override
    public Response<Void> updateProductsPricesByBranchID(double increase, int branchId) {
        synchronized (this) {
            isUpdating = true;
        }
        Response<Void> updateProductsPrices = storage.updateProductPriceByOffice(increase, branchId);
        updateProductsPrices.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: UpdateProductsPricesByBranchID");
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateProductsPricesByBranchID");
            }

        });
        synchronized (this) {
            isUpdating = false;
            resumeSync();
        }
        return updateProductsPrices;
    }

    @Override
    public Response<Void> deleteProductByBarcode(String barcode) {
        synchronized (this) {
            isDeleting = true;
        }
        Response<Void> deleteProductByBarcode = storage.deleteProductByBarcode(barcode);
        deleteProductByBarcode.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: DeleteProduct By Barcode - " + barcode);
                viewController.refresh();
                queue.add(() -> syncDeleteInAPI(barcode));
                queueBackup.add(new UnsyncedProduct(barcode, UnsyncedTaskType.DELETE));
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: DeleteProduct by Barcode - " + barcode);
                synchronized (ProductRepositoryImplementation.this) {
                    isDeleting = false;
                    resumeSync();
                }
            }

        });
        return deleteProductByBarcode;
    }

    @Override
    public void startSync() {
        AsyncTaskManager.executeAsync(this::synchronize);
    }

    @Override
    public void stopSync() {
        isSync = false;
    }

    private synchronized void resumeSync() {
        notifyAll();
    }

    private void synchronize() {

        isSync = true;

        AttemptsManager attemptsManager = new AttemptsManager();

        while (isSync) {

            queueBackup.upload();

            synchronized (this) {
                while (isAdding || isUpdating || isDeleting) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Sync Wait");
                        throw new RuntimeException(e);
                    }
                }
            }

            if (isAdding || isUpdating || isDeleting) continue;

            Map<String, Product> databaseOfAPI;
            Response<Map<String, Product>> getProductMapOfAPI = api.getProductMap();
            if (getProductMapOfAPI instanceof Response.Success<Map<String, Product>>) {
                databaseOfAPI = ((Response.Success<Map<String, Product>>) getProductMapOfAPI).getObject();
            } else {
                Console.warn(Console.WarnCode.W001, "ERROR: GetDatabaseOfAPI");
                attemptsManager.retryWithDelay();
                continue;
            }

            if (isAdding || isUpdating || isDeleting) continue;

            Map<String, Product> databaseOfStorage;
            Response<Map<String, Product>> getProductMapOfStorage = storage.getProductMap();
            if (getProductMapOfStorage instanceof Response.Success<Map<String, Product>>) {
                databaseOfStorage = ((Response.Success<Map<String, Product>>) getProductMapOfStorage).getObject();
            } else {
                Console.warn(Console.WarnCode.W001, "ERROR: GetDatabaseOfStorage");
                attemptsManager.retryWithDelay();
                continue;
            }

            if (isAdding || isUpdating || isDeleting) continue;

            databaseOfAPI.forEach((id, itemOfAPI) -> {
                Product itemOfStorage = databaseOfStorage.get(id);
                if (itemOfStorage == null) {
                    syncAddInStorage(itemOfAPI);
                } else {
                    if (itemOfAPI.getUpdatedDate().isAfter(itemOfStorage.getUpdatedDate())) {
                        syncUpdateInStorage(itemOfAPI);
                    } else if (itemOfStorage.getUpdatedDate().isAfter(itemOfAPI.getUpdatedDate())) {
                        synchronized (ProductRepositoryImplementation.this) {
                            isUpdating = false;
                        }
                        syncUpdateInAPI(itemOfStorage);
                    }
                }
            });

            if (isAdding || isUpdating || isDeleting) continue;

            if (databaseOfAPI.size() < databaseOfStorage.size()) {
                databaseOfStorage.forEach((id, itemOfStorage) -> {
                    Product itemOfAPI = databaseOfAPI.get(id);
                    if (itemOfAPI == null)
                        syncDeleteInStorage(id);
                });
            }

            attemptsManager.resetDelay();

            Console.info(Console.InfoCode.I200, "OK: Ciclo de Sincronizacion finalizado Correctamente");

        }
    }

    private void syncAddInAPI(Product product) {
        AsyncTaskManager.executeAsync(() -> {
            synchronized (ProductRepositoryImplementation.this) {
                isAdding = true;
            }
            AttemptsManager attemptsManager = new AttemptsManager();
            final boolean[] isFinished = { false };
            while (!isFinished[0] && isSync) {
                Response<Void> addProduct = api.addProduct(product);
                addProduct.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: Sync AddProduct in API - " + product.getBarcode());
                        queueBackup.poll();
                        isFinished[0] = true;
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Sync AddProduct in API - " + product.getBarcode());
                        attemptsManager.retryWithDelay();
                    }

                });
            }
            synchronized (ProductRepositoryImplementation.this) {
                isAdding = false;
                resumeSync();
            }
        });
    }

    private void syncAddInStorage(Product product) {
        synchronized (this) {
            isAdding = false;
        }
        Response<Void> addProduct = storage.syncAddProduct(product);
        addProduct.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: Sync AddProduct in Storage - " + product.getBarcode());
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: Sync AddProduct in Storage - " + product.getBarcode());
            }

        });
        synchronized (this) {
            isAdding = false;
            resumeSync();
        }
    }

    private void syncUpdateInAPI(Product product) {
        AsyncTaskManager.executeAsync(() -> {
            synchronized (ProductRepositoryImplementation.this) {
                isUpdating = true;
            }
            AttemptsManager attemptsManager = new AttemptsManager();
            final boolean[] isFinished = { false };
            while (!isFinished[0] && isSync) {
                Response<Void> updateProduct = api.updateProduct(product);
                updateProduct.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: Sync UpdateProduct in API - " + product.getBarcode());
                        queueBackup.poll();
                        isFinished[0] = true;
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Sync UpdateProduct in API - " + product.getBarcode());
                        attemptsManager.retryWithDelay();
                    }

                });
            }
            synchronized (ProductRepositoryImplementation.this) {
                isUpdating = false;
                resumeSync();
            }
        });
    }

    private void syncUpdateInStorage(Product product) {
        synchronized (this) {
            isUpdating = false;
        }
        Response<Void> updateProduct = storage.syncUpdateProduct(product);
        updateProduct.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: Sync UpdateProduct in Storage - " + product.getBarcode());
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: Sync UpdateProduct in Storage - " + product.getBarcode());
            }

        });
        synchronized (this) {
            isUpdating = false;
            resumeSync();
        }
    }

    private void syncDeleteInAPI(String barcode) {
        AsyncTaskManager.executeAsync(() -> {
            synchronized (ProductRepositoryImplementation.this) {
                isDeleting = true;
            }
            AttemptsManager attemptsManager = new AttemptsManager();
            final boolean[] isFinished = { false };
            while (!isFinished[0] && isSync) {
                Response<Void> deleteProductByBarcode = api.deleteProductByBarcode(barcode);
                deleteProductByBarcode.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: Sync DeleteProductByBarcode in API - " + barcode);
                        queueBackup.poll();
                        isFinished[0] = true;
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Sync DeleteProductByBarcode in API - " + barcode);
                        attemptsManager.retryWithDelay();
                    }

                });
            }
            synchronized (ProductRepositoryImplementation.this) {
                isDeleting = false;
                resumeSync();
            }
        });
    }

    private void syncDeleteInStorage(String barcode) {
        synchronized (this) {
            isDeleting = false;
        }
        Response<Void> deleteProductByBarcode = storage.deleteProductByBarcode(barcode);
        deleteProductByBarcode.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: Sync DeleteProductByID in Storage - " + barcode);
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: Sync DeleteProductByID in Storage - " + barcode);
            }

        });
        synchronized (this) {
            isDeleting = false;
            resumeSync();
        }
    }

    private class QueueBackup {

        private final UnsyncedProductStorage unsyncedStorage = new UnsyncedProductStorage();

        public void upload() {

            Response<List<UnsyncedProduct>> upload = unsyncedStorage.getUnsyncedProductList();
            upload.accept(new ResponseVisitor<>() {

                @Override
                public void visitSuccess(Response.Success<List<UnsyncedProduct>> success) {
                    unsyncedProducts = success.getObject();
                    unsyncedProducts.forEach(unsyncedProduct -> {
                        Response<Product> getProductByBarcode = storage.getProductByBarcode(unsyncedProduct.getBarcode());
                        getProductByBarcode.accept(new ResponseVisitor<>() {

                            @Override
                            public void visitSuccess(Response.Success<Product> success) {
                                Console.info(Console.InfoCode.I001, "OK: Upload AddTask");
                                switch (unsyncedProduct.getType()) {
                                    case ADD -> queue.add(() -> syncAddInAPI(success.getObject()));
                                    case UPDATE -> queue.add(() -> syncUpdateInAPI(success.getObject()));
                                    case DELETE -> queue.add(() -> syncDeleteInAPI(success.getObject().getBarcode()));
                                }
                            }

                            @Override
                            public void visitFailure(Response.Failure<Product> failure) {
                                Console.warn(Console.WarnCode.W001, "ERROR: GetProductByBarcode in GetProductTaskList - Type.ADD");
                            }

                        });
                    });
                }

                @Override
                public void visitFailure(Response.Failure<List<UnsyncedProduct>> failure) {
                    Console.warn(Console.WarnCode.W001, "ERROR: GetProductTaskList");
                }

            });

        }

        public void add(UnsyncedProduct unsyncedProduct) {

            Response<Void> add = unsyncedStorage.addUnsyncedProductInQueue(unsyncedProduct);
            add.accept(new ResponseVisitor<>() {

                @Override
                public void visitSuccess(Response.Success<Void> success) {
                    Console.info(Console.InfoCode.I001, "OK: Add Product Insertion in Queue - " + unsyncedProduct.getBarcode());
                    unsyncedProducts.add(unsyncedProduct);
                }

                @Override
                public void visitFailure(Response.Failure<Void> failure) {
                    Console.warn(Console.WarnCode.W001, "ERROR: Add Product Insertion in Queue - " + unsyncedProduct.getBarcode());
                }

            });

        }

        public void poll() {

            if (!unsyncedProducts.isEmpty()) {

                UnsyncedProduct unsyncedProduct = unsyncedProducts.getFirst();

                Response<Void> delete = unsyncedStorage.deleteUnsyncedProductOfQueueByID(unsyncedProduct.getId());
                delete.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: Product Synchronized - " + unsyncedProduct.getBarcode());
                        unsyncedProducts.removeFirst();
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Unsynchronized Product - " + unsyncedProduct.getBarcode());
                    }

                });

            }

        }

    }

}