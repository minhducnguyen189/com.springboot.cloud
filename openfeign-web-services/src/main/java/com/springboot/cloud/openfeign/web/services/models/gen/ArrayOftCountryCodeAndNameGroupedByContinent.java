//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.30 at 10:42:57 AM ICT 
//


package com.springboot.cloud.openfeign.web.services.models.gen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOftCountryCodeAndNameGroupedByContinent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOftCountryCodeAndNameGroupedByContinent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tCountryCodeAndNameGroupedByContinent" type="{http://www.oorsprong.org/websamples.countryinfo}tCountryCodeAndNameGroupedByContinent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOftCountryCodeAndNameGroupedByContinent", propOrder = {
    "tCountryCodeAndNameGroupedByContinent"
})
public class ArrayOftCountryCodeAndNameGroupedByContinent {

    @XmlElement(nillable = true)
    protected List<TCountryCodeAndNameGroupedByContinent> tCountryCodeAndNameGroupedByContinent;

    /**
     * Gets the value of the tCountryCodeAndNameGroupedByContinent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tCountryCodeAndNameGroupedByContinent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTCountryCodeAndNameGroupedByContinent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCountryCodeAndNameGroupedByContinent }
     * 
     * 
     */
    public List<TCountryCodeAndNameGroupedByContinent> getTCountryCodeAndNameGroupedByContinent() {
        if (tCountryCodeAndNameGroupedByContinent == null) {
            tCountryCodeAndNameGroupedByContinent = new ArrayList<TCountryCodeAndNameGroupedByContinent>();
        }
        return this.tCountryCodeAndNameGroupedByContinent;
    }

}
