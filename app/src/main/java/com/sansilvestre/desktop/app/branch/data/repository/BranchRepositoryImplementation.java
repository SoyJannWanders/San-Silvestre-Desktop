package com.sansilvestre.desktop.app.branch.data.repository;

import com.sansilvestre.desktop.app.branch.data.source.BranchAPI;
import com.sansilvestre.desktop.app.branch.data.source.BranchStorage;
import com.sansilvestre.desktop.app.branch.data.source.sync.UnsyncedBranch;
import com.sansilvestre.desktop.app.branch.data.source.sync.UnsyncedBranchStorage;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.branch.screen.BranchViewController;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.data.sync.AsyncTaskManager;
import com.sansilvestre.desktop.app.util.data.sync.AttemptsManager;
import com.sansilvestre.desktop.app.util.data.sync.UnsyncedTaskQueue;
import com.sansilvestre.desktop.app.util.data.sync.UnsyncedTaskType;
import com.sansilvestre.desktop.app.util.log.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BranchRepositoryImplementation implements BranchRepository {

    private BranchViewController viewController;

    private final BranchStorage storage;
    private final BranchAPI api;

    public BranchRepositoryImplementation(BranchStorage storage, BranchAPI api) {
        this.storage = storage;
        this.api = api;
    }

    @Override
    public void setBranchViewController(BranchViewController viewController) {
        this.viewController = viewController;
    }

    @Override
    public Response<Map<Integer, Branch>> getBranchMap() {
        Response<Map<Integer, Branch>> getBranchMap = storage.getBranchMap();
        getBranchMap.accept(new ResponseVisitor<>() {
            @Override
            public void visitSuccess(Response.Success<Map<Integer, Branch>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetBranchMap");
            }

            @Override
            public void visitFailure(Response.Failure<Map<Integer, Branch>> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: GetBranchMap");
            }
        });
        return getBranchMap;
    }

    @Override
    public Response<List<Branch>> getBranchList() {
        Response<List<Branch>> getBranchList = storage.getBranchList();
        getBranchList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Branch>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetBranchList");
            }

            @Override
            public void visitFailure(Response.Failure<List<Branch>> failure) {
                Console.info(Console.InfoCode.I001, "ERROR: GetBranchList");
            }

        });
        return getBranchList;
    }

    @Override
    public Response<List<Branch>> getBranchListBySearch(String search) {
        Response<List<Branch>> getBranchList = storage.getBranchListBySearch(search);
        getBranchList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Branch>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetBranchList by Search");
            }

            @Override
            public void visitFailure(Response.Failure<List<Branch>> failure) {
                Console.info(Console.InfoCode.I001, "ERROR: GetBranchList by Search");
            }

        });
        return getBranchList;
    }

    @Override
    public Response<Void> addBranch(Branch branch) {
        Response<Void> addBranch = storage.addBranch(branch);
        addBranch.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: AddBranch");
                viewController.refresh();
                queue.add(() -> syncAddInAPI(branch));
                queueBackup.add(new UnsyncedBranch(branch.getId(), UnsyncedTaskType.ADD));
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: AddBranch");
            }

        });
        return addBranch;
    }

    @Override
    public Response<Void> updateBranch(Branch branch) {
        Response<Void> updateBranch = storage.updateBranch(branch);
        updateBranch.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: UpdateBranch");
                viewController.refresh();
                queue.add(() -> syncUpdateInAPI(branch));
                queueBackup.add(new UnsyncedBranch(branch.getId(), UnsyncedTaskType.UPDATE));
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateBranch");
            }

        });
        return updateBranch;
    }

    @Override
    public Response<Void> deleteBranchByID(int id) {
        Response<Void> deleteCategoryByID = storage.deleteBranchByID(id);
        deleteCategoryByID.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: DeleteBranch By ID - " + id);
                viewController.refresh();
                queue.add(() -> syncDeleteInAPI(id));
                queueBackup.add(new UnsyncedBranch(id, UnsyncedTaskType.DELETE));
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: DeleteBranch By ID - " + id);
            }

        });
        return deleteCategoryByID;
    }

    private final UnsyncedTaskQueue queue = new UnsyncedTaskQueue();
    private final QueueBackup queueBackup = new QueueBackup();

    private boolean isSync = true;

    private boolean isAdding = false;
    private boolean isUpdating = false;
    private boolean isDeleting = false;

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

            Map<Integer, Branch> databaseOfAPI;
            Response<Map<Integer, Branch>> getProductMapOfAPI = api.getBranchMap();
            if (getProductMapOfAPI instanceof Response.Success<Map<Integer, Branch>>) {
                databaseOfAPI = ((Response.Success<Map<Integer, Branch>>) getProductMapOfAPI).getObject();
            } else {
                Console.warn(Console.WarnCode.W001, "ERROR: GetDatabaseOfAPI");
                attemptsManager.retryWithDelay();
                continue;
            }

            if (isAdding || isUpdating || isDeleting) continue;

            Map<Integer, Branch> databaseOfStorage;
            Response<Map<Integer, Branch>> getProductMapOfStorage = storage.getBranchMap();
            if (getProductMapOfStorage instanceof Response.Success<Map<Integer, Branch>>) {
                databaseOfStorage = ((Response.Success<Map<Integer, Branch>>) getProductMapOfStorage).getObject();
            } else {
                Console.warn(Console.WarnCode.W001, "ERROR: GetDatabaseOfStorage");
                attemptsManager.retryWithDelay();
                continue;
            }

            if (isAdding || isUpdating || isDeleting) continue;

            databaseOfAPI.forEach((id, itemOfAPI) -> {
                Branch itemOfStorage = databaseOfStorage.get(id);
                if (itemOfStorage == null) {
                    syncAddInStorage(itemOfAPI);
                } else {
                    if (itemOfAPI.getUpdatedDate().isAfter(itemOfStorage.getUpdatedDate())) {
                        syncUpdateInStorage(itemOfAPI);
                    } else if (itemOfStorage.getUpdatedDate().isAfter(itemOfAPI.getUpdatedDate())) {
                        synchronized (BranchRepositoryImplementation.this) {
                            isUpdating = false;
                        }
                        syncUpdateInAPI(itemOfStorage);
                    }
                }
            });

            if (isAdding || isUpdating || isDeleting) continue;

            if (databaseOfAPI.size() < databaseOfStorage.size()) {
                databaseOfStorage.forEach((id, itemOfStorage) -> {
                    Branch itemOfAPI = databaseOfAPI.get(id);
                    if (itemOfAPI == null)
                        syncDeleteInStorage(id);
                });
            }

            attemptsManager.resetDelay();

            Console.info(Console.InfoCode.I200, "OK: Ciclo de Sincronizacion finalizado Correctamente");

        }
    }

    private void syncAddInAPI(Branch branch) {
        AsyncTaskManager.executeAsync(() -> {
            synchronized (BranchRepositoryImplementation.this) {
                isAdding = true;
            }
            AttemptsManager attemptsManager = new AttemptsManager();
            final boolean[] isFinished = { false };
            while (!isFinished[0] && isSync) {
                Response<Void> addProduct = api.addBranch(branch);
                addProduct.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: Sync AddBranch in API - " + branch.getId());
                        queueBackup.poll();
                        isFinished[0] = true;
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Sync AddBranch in API - " + branch.getId());
                        attemptsManager.retryWithDelay();
                    }

                });
            }
            synchronized (BranchRepositoryImplementation.this) {
                isAdding = false;
                resumeSync();
            }
        });
    }

    private void syncAddInStorage(Branch branch) {
        synchronized (this) {
            isAdding = false;
        }
        Response<Void> addProduct = storage.syncAddBranch(branch);
        addProduct.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: Sync AddBranch in Storage - " + branch.getId());
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: Sync AddBranch in Storage - " + branch.getId());
            }

        });
        synchronized (this) {
            isAdding = false;
            resumeSync();
        }
    }

    private void syncUpdateInAPI(Branch branch) {
        AsyncTaskManager.executeAsync(() -> {
            synchronized (BranchRepositoryImplementation.this) {
                isUpdating = true;
            }
            AttemptsManager attemptsManager = new AttemptsManager();
            final boolean[] isFinished = { false };
            while (!isFinished[0] && isSync) {
                Response<Void> updateProduct = api.updateBranch(branch);
                updateProduct.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: Sync UpdateBranch in API - " + branch.getId());
                        queueBackup.poll();
                        isFinished[0] = true;
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Sync UpdateBranch in API - " + branch.getId());
                        attemptsManager.retryWithDelay();
                    }

                });
            }
            synchronized (BranchRepositoryImplementation.this) {
                isUpdating = false;
                resumeSync();
            }
        });
    }

    private void syncUpdateInStorage(Branch branch) {
        synchronized (this) {
            isUpdating = false;
        }
        Response<Void> updateProduct = storage.syncUpdateBranch(branch);
        updateProduct.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: Sync UpdateProduct in Storage - " + branch.getId());
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: Sync UpdateProduct in Storage - " + branch.getId());
            }

        });
        synchronized (this) {
            isUpdating = false;
            resumeSync();
        }
    }

    private void syncDeleteInAPI(int id) {
        AsyncTaskManager.executeAsync(() -> {
            synchronized (BranchRepositoryImplementation.this) {
                isDeleting = true;
            }
            AttemptsManager attemptsManager = new AttemptsManager();
            final boolean[] isFinished = { false };
            while (!isFinished[0] && isSync) {
                Response<Void> deleteProductByBarcode = api.deleteBranchByID(id);
                deleteProductByBarcode.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: Sync DeleteBranch By Barcode in API - " + id);
                        queueBackup.poll();
                        isFinished[0] = true;
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Sync DeleteBranch By Barcode in API - " + id);
                        attemptsManager.retryWithDelay();
                    }

                });
            }
            synchronized (BranchRepositoryImplementation.this) {
                isDeleting = false;
                resumeSync();
            }
        });
    }

    private void syncDeleteInStorage(int id) {
        synchronized (this) {
            isDeleting = false;
        }
        Response<Void> deleteProductByBarcode = storage.deleteBranchByID(id);
        deleteProductByBarcode.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: Sync DeleteBranch By ID in Storage - " + id);
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: Sync DeleteBranch By ID in Storage - " + id);
            }

        });
        synchronized (this) {
            isDeleting = false;
            resumeSync();
        }
    }

    private class QueueBackup {

        private final UnsyncedBranchStorage unsyncedStorage = new UnsyncedBranchStorage();

        private List<UnsyncedBranch> unsyncedBranches = new ArrayList<>();

        public void upload() {

            Response<List<UnsyncedBranch>> upload = unsyncedStorage.getUnsyncedBranchList();
            upload.accept(new ResponseVisitor<>() {

                @Override
                public void visitSuccess(Response.Success<List<UnsyncedBranch>> success) {
                    unsyncedBranches = success.getObject();
                    unsyncedBranches.forEach(unsyncedBranch -> {
                        Response<Branch> getProductByBarcode = storage.getBranchByID(unsyncedBranch.getBranchId());
                        getProductByBarcode.accept(new ResponseVisitor<>() {

                            @Override
                            public void visitSuccess(Response.Success<Branch> success) {
                                Console.info(Console.InfoCode.I001, "OK: Upload AddTask");
                                switch (unsyncedBranch.getType()) {
                                    case ADD -> queue.add(() -> syncAddInAPI(success.getObject()));
                                    case UPDATE -> queue.add(() -> syncUpdateInAPI(success.getObject()));
                                    case DELETE -> queue.add(() -> syncDeleteInAPI(success.getObject().getId()));
                                }
                            }

                            @Override
                            public void visitFailure(Response.Failure<Branch> failure) {
                                Console.warn(Console.WarnCode.W001, "ERROR: GetProductByBarcode in GetProductTaskList - Type.ADD");
                            }

                        });
                    });
                }

                @Override
                public void visitFailure(Response.Failure<List<UnsyncedBranch>> failure) {
                    Console.warn(Console.WarnCode.W001, "ERROR: GetProductTaskList");
                }

            });

        }

        public void add(UnsyncedBranch unsyncedBranch) {

            Response<Void> add = unsyncedStorage.addUnsyncedBranchInQueue(unsyncedBranch);
            add.accept(new ResponseVisitor<>() {

                @Override
                public void visitSuccess(Response.Success<Void> success) {
                    Console.info(Console.InfoCode.I001, "OK: Add Product Insertion in Queue - " + unsyncedBranch.getBranchId());
                    unsyncedBranches.add(unsyncedBranch);
                }

                @Override
                public void visitFailure(Response.Failure<Void> failure) {
                    Console.warn(Console.WarnCode.W001, "ERROR: Add Product Insertion in Queue - " + unsyncedBranch.getBranchId());
                }

            });

        }

        public void poll() {

            if (!unsyncedBranches.isEmpty()) {

                UnsyncedBranch unsyncedBranch = unsyncedBranches.getFirst();

                Response<Void> delete = unsyncedStorage.deleteUnsyncedBranchOfQueueByID(unsyncedBranch.getId());
                delete.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: Product Synchronized - " + unsyncedBranch.getBranchId());
                        unsyncedBranches.removeFirst();
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Unsynchronized Product - " + unsyncedBranch.getBranchId());
                    }

                });

            }

        }

    }

}