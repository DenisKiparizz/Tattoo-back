package com.tattoo.com.repository;

public final class SqlQuery {
    private SqlQuery() {
    }

    //language=SQL
    public static final String GET_TOTAL_PRICE =
            "SELECT sum(price) AS total "
                    + "FROM orders "
                    + "JOIN order_user ou ON orders.id = ou.order_id "
                    + "WHERE ou.user_id = :id";

    //language=SQL
    public static final String GET_ORDERS_BY_USER_ID =
            "SELECT o.* "
                    + "FROM orders o "
                    + "JOIN order_user ou on o.id = ou.order_id "
                    + "WHERE user_id = :id ";

    //language=SQL
    public static final String UPDATE_ORDER_STATUS_CLOSED =
            "UPDATE orders o "
                    + "SET o.status = 'CLOSED' "
                    + "WHERE o.id =:id ";
}
