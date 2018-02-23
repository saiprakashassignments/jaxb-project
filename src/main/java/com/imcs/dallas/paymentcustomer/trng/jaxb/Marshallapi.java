package com.imcs.dallas.paymentcustomer.trng.jaxb;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Node;

public class Marshallapi {
public static void main(String[] args) {
//	Marshallapi.marshall();
	Marshallapi.unmarshall();
}

private static void marshall() {
	try{
	    //creating the JAXB context
	    JAXBContext jContext = JAXBContext.newInstance(CustomerType.class);
	    //creating the marshaller object
	    Marshaller marshallObj = jContext.createMarshaller();
	    //setting the property to show xml format output
	    marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    //setting the values in POJO class
	    AddressType at=new AddressType();
	    at.setPhonenumber("145622");
	    at.setStreetName("dallas");
	    at.setStreetNo(10);
	    at.setZipCode(45);
	    at.setStreetName("lovedr");
	    
	    CustomerType customertype = new CustomerType();
	    customertype.setName("sai");
	    customertype.setCustomerid(1);
	    customertype.setAnnualSalary("458");
	    customertype.setDateofBirth("10-10-2017");
	    customertype.setAddress(at);
	    customertype.setPaymentMethods("creditcard");
	    
	    //calling the marshall method
	    marshallObj.marshal(customertype, new FileOutputStream("D:\\eclipse\\paymentcustomer\\src\\main\\java\\resources\\Customercheck.xml"));
	} catch(Exception e) {
	    e.printStackTrace();
	}
}


private static void unmarshall() {
	try{
	    //creating the JAXB context
	    JAXBContext jContext = JAXBContext.newInstance(CustomerType.class);
	    //creating the marshaller object
	    Unmarshaller unmarshallObj = jContext.createUnmarshaller();
	    //setting the property to show xml format output
	  //  unmarshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    //setting the values in POJO class
	  
	    //calling the marshall method
	   CustomerType ct= (CustomerType)unmarshallObj.unmarshal( new File("D:\\eclipse\\paymentcustomer\\src\\main\\java\\resources\\Customercheck.xml"));
	System.out.println(ct.getAnnualSalary()+"  "+ct.getCustomerid()+"   "+"    "+ct.getDateofBirth()+"    "+ct.getName()+"    "+ct.getPaymentMethods());
	
	} catch(Exception e) {
	    e.printStackTrace();
	}
}
}
