package demo.domain

import spock.lang.Specification
import spock.lang.Unroll

class OrderSpec extends Specification {

    def "constructor"(){
        setup:
        Order order;

        when:
        order = new Order(3,"laptop",155000)

        then:
        order.getQuantity()==3
        order.getItemName()=="laptop"
        order.getPrice()==155000

    }

    @Unroll
    def "set Item Name"(){
        setup:
        Order order = new Order();

        when:
        order.setItemName(set)

        then:
        order.getItemName()==get

        where:
        set|get
        "laptop"|"laptop"
        "mobile"|"mobile"
    }

    @Unroll
    def "set Price"(){
        setup:
        Order order = new Order();

        when:
        order.setPrice(set)

        then:
        order.getPrice()==get

        where:
        set|get
        5000.68|5000.68
        0|0

    }

    @Unroll
    def "set Price With Tax"() {
        setup:
        Order order = new Order();

        when:
        order.setPriceWithTex(set)

        then:
        order.getPriceWithTex()==get

        where:
        set|get
        2078.87|3200.87
        0|0

    }

    @Unroll
    def "set Quantity"(){
        setup:
        Order order = new Order();

        when:
        order.setQuantity(set)

        then:
        order.getQuantity()==get

        where:
        set|get
        70|70
        60|60
    }

}
