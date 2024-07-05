package com.sansilvestre.desktop.app;

import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.sansilvestre.desktop.app.auth.screen.AuthScreen;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.screen.BranchScreen;
import com.sansilvestre.desktop.app.branch.screen.add.AddBranchScreen;
import com.sansilvestre.desktop.app.category.screen.CategoryScreen;
import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.checkout.screen.CheckoutViewController;
import com.sansilvestre.desktop.app.home.screen.HomeScreen;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.screen.ProductScreen;
import com.sansilvestre.desktop.app.product.screen.add.AddProductScreen;
import com.sansilvestre.desktop.app.product.screen.other.search.SearchProductScreen;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.sale.screen.other.detail.DetailSaleScreen;
import com.sansilvestre.desktop.app.sale.screen.other.local.LocaleSaleScreen;
import com.sansilvestre.desktop.app.product.screen.update.UpdateProductScreen;
import com.sansilvestre.desktop.app.sale.screen.add.AddSaleScreen;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.session.screen.other.arch.ArchSessionScreen;
import com.sansilvestre.desktop.app.session.screen.other.close.CloseSessionScreen;
import com.sansilvestre.desktop.app.session.screen.other.swap.SwapSessionScreen;
import com.sansilvestre.desktop.app.setting.screen.SettingScreen;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.shift.screen.ShiftScreen;
import com.sansilvestre.desktop.app.shift.screen.add.AddShiftScreen;
import com.sansilvestre.desktop.app.shift.screen.update.UpdateShiftScreen;
import com.sansilvestre.desktop.app.user.screen.UserScreen;
import com.sansilvestre.desktop.app.user.screen.other.calculate.CalculateUserSalaryScreen;
import com.sansilvestre.desktop.app.util.ui.window.develop.DevelopScreen;
import com.sansilvestre.desktop.app.branch.screen.update.UpdateBranchScreen;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.screen.add.AddCategoryScreen;
import com.sansilvestre.desktop.app.category.screen.update.UpdateCategoryScreen;
import com.sansilvestre.desktop.app.dashboard.screen.DashboardScreen;
import com.sansilvestre.desktop.app.launch.screen.LaunchScreen;
import com.sansilvestre.desktop.app.session.screen.other.open.OpenSessionScreen;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.screen.add.AddUserScreen;
import com.sansilvestre.desktop.app.user.screen.update.UpdateUsersSalariesScreen;
import com.sansilvestre.desktop.app.user.screen.update.UpdateUserSalaryScreen;
import com.sansilvestre.desktop.app.user.screen.update.UpdateUserScreen;
import com.sansilvestre.desktop.app.util.ui.window.delete.DeleteScreen;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class NavigationController {
    
    private static NavigationController instance;

    private App app;

    private JDialog windows;
    
    private NavigationController() {}
    
    public static NavigationController getInstance() {
        if (instance == null) 
            instance = new NavigationController();
        return instance;
    }

    public void initApp(App app) {
        this.app = app;
    }

    public enum Route {

        DISPOSE_SCREEN,


        LAUNCH_SCREEN,
        OPEN_SESSION_SCREEN,
        ARCH_SESSION_SCREEN,
        CLOSE_SESSION_SCREEN,
        SWAP_SESSION_SCREEN,



        AUTH_SCREEN,



        DASHBOARD_SCREEN,



        HOME_SCREEN,



        BRANCH_SCREEN,
        ADD_BRANCH_SCREEN,
        UPDATE_BRANCH_SCREEN,



        SHIFT_SCREEN,
        ADD_SHIFT_SCREEN,
        UPDATE_SHIFT_SCREEN,



        CHECKOUT_SCREEN,
        ADD_CHECKOUT_SCREEN,
        UPDATE_CHECKOUT_SCREEN,



        PRODUCT_SCREEN,
        ADD_PRODUCT_SCREEN,
        UPDATE_PRODUCT_SCREEN,
        SEARCH_PRODUCT_SCREEN,



        CATEGORY_SCREEN,
        ADD_CATEGORY_SCREEN,
        UPDATE_CATEGORY_SCREEN,



        USER_SCREEN,
        ADD_USER_SCREEN,
        UPDATE_USER_SCREEN,
        UPDATE_USER_SALARY_SCREEN,
        UPDATE_USERS_SALARIES_SCREEN,
        CALCULATE_USER_SALARY_SCREEN,



        CLIENT_SCREEN,
        ADD_CLIENT_SCREEN,
        UPDATE_CLIENT_SCREEN,


        SALE_SCREEN,
        ADD_SALE_SCREEN,
        LOCALE_SALE_SCREEN,
        DETAIL_SALE_SCREEN,



        SETTING_SCREEN,



        DELETE_SCREEN,



        DEVELOPMENT_SCREEN

    }

    public void navigate(Route route, NavigationData data) {
        if (windows == null) {
            windows = new JDialog(app, null, true);
            windows.setIconImage(new ImageIcon(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)).getImage());
            windows.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }
        switch (route) {

            case DISPOSE_SCREEN -> {
                if (data != null) {
                    JPanel window = data.getDataAs(0, JPanel.class);
                    SwingUtilities.getWindowAncestor(window).dispose();
                }
            }



            case LAUNCH_SCREEN ->
                navigateTo(new LaunchScreen());
            case OPEN_SESSION_SCREEN -> {
                if (data != null) {
                    int checkoutId = data.getDataAs(0, Integer.class);
                    prepareWindow(new OpenSessionScreen(checkoutId));
                }
            }
            case ARCH_SESSION_SCREEN -> {
                if (data != null) {
                    Session sessionId = data.getDataAs(0, Session.class);
                    int checkoutId = data.getDataAs(1, Integer.class);
                    double closeAmount = data.getDataAs(2, Double.class);
                    prepareWindow(new ArchSessionScreen(sessionId, checkoutId, closeAmount));
                }
            }
            case CLOSE_SESSION_SCREEN -> {
                if (data != null) {
                    int sessionId = data.getDataAs(0, Integer.class);
                    double closeAmount = data.getDataAs(1, Double.class);
                    prepareWindow(new CloseSessionScreen(sessionId, closeAmount));
                }
            }
            case SWAP_SESSION_SCREEN -> {
                if (data != null) {
                    Session session = data.getDataAs(0, Session.class);
                    int checkoutId = data.getDataAs(1, Integer.class);
                    prepareWindow(new SwapSessionScreen(session, checkoutId));
                }
            }



            case AUTH_SCREEN -> {
                navigateTo(new AuthScreen());
            }



            case DASHBOARD_SCREEN -> {
                if (data != null) {
                    Role role = data.getDataAs(0, Role.class);
                    navigateTo(new DashboardScreen(role));
                }
            }



            case HOME_SCREEN -> {
                DashboardScreen.getInstance().navigateTo(new HomeScreen());
            }



            case BRANCH_SCREEN -> {
                DashboardScreen.getInstance().navigateTo(new BranchScreen());
            }
            case ADD_BRANCH_SCREEN ->
                    prepareWindow(new AddBranchScreen());
            case UPDATE_BRANCH_SCREEN -> {
                if (data != null) {
                    Branch branch = data.getDataAs(0, Branch.class);
                    prepareWindow(new UpdateBranchScreen(branch));
                }
            }



            case SHIFT_SCREEN -> {
                DashboardScreen.getInstance().navigateTo(new ShiftScreen());
            }
            case ADD_SHIFT_SCREEN -> {
                prepareWindow(new AddShiftScreen());
            }
            case UPDATE_SHIFT_SCREEN -> {
                if (data != null) {
                    Shift shift = data.getDataAs(0, Shift.class);
                    Checkout checkout = data.getDataAs(1, Checkout.class);
                    prepareWindow(new UpdateShiftScreen(shift, checkout));
                }
            }



            case PRODUCT_SCREEN -> {
                DashboardScreen.getInstance().navigateTo(new ProductScreen());
            }
            case ADD_PRODUCT_SCREEN -> {
                if (data != null) {
                    Map<Integer, Category> categories = data.getDataAs(0, Map.class);
                    prepareWindow(new AddProductScreen(categories));
                }
            }
            case UPDATE_PRODUCT_SCREEN -> {
                if (data != null) {
                    Map<Integer, Category> categories = data.getDataAs(0, Map.class);
                    Product product = data.getDataAs(1, Product.class);
                    prepareWindow(new UpdateProductScreen(categories, product));
                }
            }
            case SEARCH_PRODUCT_SCREEN -> {
                prepareWindow(new SearchProductScreen());
            }



            case CATEGORY_SCREEN -> {
                DashboardScreen.getInstance().navigateTo(new CategoryScreen());
            }
            case ADD_CATEGORY_SCREEN ->
                    prepareWindow(new AddCategoryScreen());
            case UPDATE_CATEGORY_SCREEN -> {
                if (data != null) {
                    Category category = data.getDataAs(0, Category.class);
                    prepareWindow(new UpdateCategoryScreen(category));
                }
            }



            case USER_SCREEN -> {
                DashboardScreen.getInstance().navigateTo(new UserScreen());
            }
            case ADD_USER_SCREEN -> {
                if (data != null) {
                    List<Role> roles = data.getDataAs(0, List.class);
                    Map<Integer, Branch> branches = data.getDataAs(1, Map.class);
                    prepareWindow(new AddUserScreen(roles, branches));
                }
            }
            case UPDATE_USER_SCREEN -> {
                if (data != null) {
                    List<Role> roles = data.getDataAs(0, List.class);
                    Map<Integer, Branch> branches = data.getDataAs(1, Map.class);
                    User user = data.getDataAs(2, User.class);
                    prepareWindow(new UpdateUserScreen(roles, branches, user));
                }
            }
            case UPDATE_USER_SALARY_SCREEN -> {
                if (data != null) {
                    int id = data.getDataAs(0, Integer.class);
                    double salary = data.getDataAs(1, Double.class);
                    prepareWindow(new UpdateUserSalaryScreen(id, salary));
                }
            }
            case UPDATE_USERS_SALARIES_SCREEN -> {
                if (data != null) {
                    Map<Integer, Branch> branches = data.getDataAs(0, Map.class);
                    prepareWindow(new UpdateUsersSalariesScreen(branches));
                }
            }
            case CALCULATE_USER_SALARY_SCREEN -> {
                if (data != null) {
                    String name = data.getDataAs(0, String.class);
                    double salary = data.getDataAs(1, Double.class);
                    prepareWindow(new CalculateUserSalaryScreen(name, salary));
                }
            }



            case CLIENT_SCREEN -> {}
            case ADD_CLIENT_SCREEN -> {}
            case UPDATE_CLIENT_SCREEN -> {}



            case SALE_SCREEN -> {}
            case ADD_SALE_SCREEN -> {
                if (data != null) {
                    List<Item> items = data.getDataAs(0, List.class);
                    Session session = data.getDataAs(1, Session.class);
                    CheckoutViewController viewController = data.getDataAs(2, CheckoutViewController.class);
                    prepareWindow(new AddSaleScreen(items, session, viewController));
                }
            }
            case LOCALE_SALE_SCREEN -> {
                if (data != null) {
                    int branchId = data.getDataAs(0, Integer.class);
                    prepareWindow(new LocaleSaleScreen(branchId));
                }
            }
            case DETAIL_SALE_SCREEN -> {
                if (data != null) {
                    Sale sale = data.getDataAs(0, Sale.class);
                    prepareWindow(new DetailSaleScreen(sale));
                }
            }



            case SETTING_SCREEN -> {
                DashboardScreen.getInstance().navigateTo(new SettingScreen());
            }



            case DELETE_SCREEN -> {
                if (data != null) {
                    Runnable task = data.getDataAs(0, Runnable.class);
                    prepareWindow(new DeleteScreen(task));
                }
            }



            case DEVELOPMENT_SCREEN -> {

                if (data != null) {
                    Runnable task = data.getDataAs(0, Runnable.class);
                    prepareWindow(new DevelopScreen(task));
                }
            }

        }
    }

    public void prepareWindow(JPanel content) {
        windows.getContentPane().removeAll();
        windows.setResizable(false);
        windows.add(content);
        windows.pack();
        windows.setLocationRelativeTo(app);
        windows.setVisible(true);
    }

    public void navigateTo(JComponent route) {
        EventQueue.invokeLater(() -> {
            FlatAnimatedLafChange.showSnapshot();
            if (app.isUndecorated()) {
                app.setVisible(false);
                app.dispose();
                app.setUndecorated(false);
                app.setVisible(true);
            }
            app.getContentPane().removeAll();
            app.add(route);
            app.pack();
            app.setLocationRelativeTo(null);
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        });
    }

    public void navigateBack(JPanel window) {
        SwingUtilities.getWindowAncestor(window).dispose();
    }

    public void navigateToAddOfficeScreen() {
        SwingUtilities.invokeLater(() -> {
            JDialog view = new JDialog(app, null, true);
            view.setIconImage(new ImageIcon(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)).getImage());
            view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            view.setResizable(false);
            view.add(new AddBranchScreen());
            view.pack();
            view.setLocationRelativeTo(app);
            view.setVisible(true);
        });
    }

}