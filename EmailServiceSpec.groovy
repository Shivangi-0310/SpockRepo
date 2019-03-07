package demo.service

import demo.domain.Order
import spock.lang.Specification
import spock.lang.Unroll

class EmailServiceSpec extends Specification {
    def "Send Email"() {
        setup:
        EmailService emailservice = EmailService.getInstance();

        when:
        Order order = Mock(Order)
        emailservice.sendEmail(order);

        then:
        thrown(RuntimeException)
    }

    def "Send Email using a string"() {
        setup:
        EmailService emailservice = EmailService.getInstance();

        when:
        Order order = Mock(Order)
        Boolean result = emailservice.sendEmail(order,"order1");

        then:
        result
    }

    def "send email with a string for cancel order"(){
        setup:
        EmailService emailservice = EmailService.getInstance();

        when:
        Order order = Mock(Order)
        boolean result = emailservice.sendEmail(order,string)

        then:
        result==inputstatus

        where:
        string|inputstatus
        "cancel"|true
        "again"|false
 	"abcd"|false
        "one"|false
    }


}
