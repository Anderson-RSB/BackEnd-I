package br.com.digitalhouse.ecommerce.dtos;

import br.com.digitalhouse.ecommerce.entities.Purchase;

import java.io.Serializable;

public class PurchaseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer ordernumber;

    public PurchaseDto() {
    }

    public PurchaseDto(Integer id, Integer ordernumber) {
        this.id = id;
        this.ordernumber = ordernumber;
    }

    public PurchaseDto(Purchase purchase) {
        this.id = purchase.getId();
        this.ordernumber = purchase.getOrdernumber();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

}