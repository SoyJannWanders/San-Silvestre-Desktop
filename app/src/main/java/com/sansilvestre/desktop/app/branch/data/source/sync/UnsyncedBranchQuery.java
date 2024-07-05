package com.sansilvestre.desktop.app.branch.data.source.sync;

public class UnsyncedBranchQuery {

    public static final String SELECT_UNSYNCED_BRANCHES =
            "SELECT * FROM unsynced_branches ORDER BY created_at ASC;";

    public static final String ADD_UNSYNCED_BRANCH_IN_QUEUE =
            "INSERT INTO unsynced_branches (branch_id, type) VALUES (?, ?);";

    public static final String DELETE_UNSYNCED_BRANCH_OF_QUEUE_BY_ID =
            "DELETE FROM unsynced_branches WHERE id = ?;";

}