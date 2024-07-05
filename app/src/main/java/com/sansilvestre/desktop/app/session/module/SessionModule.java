package com.sansilvestre.desktop.app.session.module;

import com.sansilvestre.desktop.app.session.data.repository.SessionRepositoryImplementation;
import com.sansilvestre.desktop.app.session.data.source.SessionStorage;
import com.sansilvestre.desktop.app.session.domain.repository.SessionRepository;
import com.sansilvestre.desktop.app.session.domain.usecase.CloseSession;
import com.sansilvestre.desktop.app.session.domain.usecase.OpenSession;
import com.sansilvestre.desktop.app.session.screen.other.arch.ArchSessionViewModel;
import com.sansilvestre.desktop.app.session.screen.other.close.CloseSessionViewModel;
import com.sansilvestre.desktop.app.session.screen.other.open.OpenSessionViewModel;
import com.sansilvestre.desktop.app.session.screen.other.swap.SwapSessionViewModel;
import com.sansilvestre.desktop.app.transaction.data.repository.TransactionRepositoryImplementation;
import com.sansilvestre.desktop.app.transaction.data.source.TransactionStorage;
import com.sansilvestre.desktop.app.transaction.domain.repository.TransactionRepository;
import com.sansilvestre.desktop.app.transaction.domain.usecase.AddTransaction;
import com.sansilvestre.desktop.app.transaction.domain.usecase.GetTotalAmountBySessionID;

public class SessionModule {

    private static SessionModule instance;

    private final SessionRepository sessionRepository;
    private final TransactionRepository transactionRepository;

    private SessionModule() {
        sessionRepository = new SessionRepositoryImplementation(new SessionStorage());
        transactionRepository = new TransactionRepositoryImplementation(new TransactionStorage());
    }

    public static SessionModule getInstance() {
        if (instance == null)
            instance = new SessionModule();
        return instance;
    }

    public OpenSessionViewModel provideOpenSessionViewModel() {
        return new OpenSessionViewModel(
                provideOpenSessionUseCase(),
                provideAddTransactionUseCase()
        );
    }

    private OpenSession provideOpenSessionUseCase() {
        return new OpenSession(sessionRepository);
    }

    public ArchSessionViewModel provideArchSessionViewModel() {
        return new ArchSessionViewModel(
                provideOpenSessionUseCase(),
                provideCloseSessionUseCase(),
                provideAddTransactionUseCase()
        );
    }

    private AddTransaction provideAddTransactionUseCase() {
        return new AddTransaction(transactionRepository);
    }

    public CloseSessionViewModel provideCloseSessionViewModel() {
        return new CloseSessionViewModel(
                provideCloseSessionUseCase(),
                provideAddTransactionUseCase()
        );
    }

    private CloseSession provideCloseSessionUseCase() {
        return new CloseSession(sessionRepository);
    }

    public SwapSessionViewModel provideSwapSessionViewModel() {
        return new SwapSessionViewModel(
                provideGetTotalAmountBySessionIDUseCase()
        );
    }

    private GetTotalAmountBySessionID provideGetTotalAmountBySessionIDUseCase() {
        return new GetTotalAmountBySessionID(transactionRepository);
    }

}