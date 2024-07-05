package com.sansilvestre.desktop.app.checkout.data.source;

public class CheckoutQuery {

    public static final String GET_CHECKOUTS =
            "SELECT * FROM checkouts;";

    public static final String OPEN_CHECKOUT =
            "UPDATE checkouts SET state = ? WHERE ID = ?";

    public static final String INSERT_CHECKOUT =
            "INSERT INTO checkouts (name, branch_id) VALUES (?, ?);";

    public static final String UPDATE_CHECKOUT =
            "UPDATE checkouts SET name = ? WHERE id = ?;";

    public static final String DELETE_CHECKOUT_BY_ID =
            "DELETE FROM checkouts WHERE id = ?;";

}