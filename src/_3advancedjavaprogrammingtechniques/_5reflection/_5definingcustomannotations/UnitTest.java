package _3advancedjavaprogrammingtechniques._5reflection._5definingcustomannotations;

public interface UnitTest {
    default void beforeEachTest() {
    }

    default void afterEachTest() {
    }
}
