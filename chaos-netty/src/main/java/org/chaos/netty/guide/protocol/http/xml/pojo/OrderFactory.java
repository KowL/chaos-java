package org.chaos.netty.guide.protocol.http.xml.pojo;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-10 11:20
 * @Modified By:
 */
public class OrderFactory {
    public static Order create(long orderID) {
        Order order = new Order();
        order.setOrderNumber(orderID);
        order.setTotal(9999.999f);
        Address address = new Address();
        address.setCity("南京市");
        address.setCountry("中国");
        address.setPostCode("123321");
        address.setState("江苏省");
        address.setStreet1("龙眠大道");
        order.setBillTo(address);
        Customer customer = new Customer();
        customer.setCustomerNumber(orderID);
        customer.setFirstName("李");
        customer.setLastName("林峰");
        order.setCustomer(customer);
        order.setShipping(Shipping.INTERNATIONAL_MAIL);
        order.setShipTo(address);
        return order;
    }
}
