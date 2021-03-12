package org.chaos.netty.guide.protocol.http.xml;

import org.chaos.netty.guide.protocol.http.xml.pojo.Address;
import org.chaos.netty.guide.protocol.http.xml.pojo.Customer;
import org.chaos.netty.guide.protocol.http.xml.pojo.Order;
import org.chaos.netty.guide.protocol.http.xml.pojo.Shipping;
import org.jibx.binding.generator.BindGen;
import org.jibx.runtime.JiBXException;

import java.io.IOException;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-10 13:55
 * @Modified By:
 */
public class JiBXBind {

    public static void main(String[] args) throws JiBXException, IOException {
        System.out.println(Order.class.getTypeName());
        BindGen.main(new String[]{"-t", "E:\\Code\\chaos\\chaos-netty\\src\\main\\resources\\jibx", "-v",
                Address.class.getTypeName(), Customer.class.getTypeName(), Shipping.class.getTypeName(), Order.class.getTypeName()});
    }
}
