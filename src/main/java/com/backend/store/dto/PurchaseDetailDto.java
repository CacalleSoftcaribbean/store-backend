package com.backend.store.dto;

public class PurchaseDetailDto {
    private Integer idPurchaseDetail, quantity;
    private ProductDto productDto;
    private PurchaseDto purchaseDto;

    public Integer getIdPurchaseDetail() {
        return idPurchaseDetail;
    }

    public void setIdPurchaseDetail(Integer idPurchaseDetail) {
        this.idPurchaseDetail = idPurchaseDetail;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public PurchaseDto getPurchaseDto() {
        return purchaseDto;
    }

    public void setPurchaseDto(PurchaseDto purchaseDto) {
        this.purchaseDto = purchaseDto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
