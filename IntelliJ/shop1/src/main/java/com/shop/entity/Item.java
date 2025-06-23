package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import com.shop.exception.OutOfStockException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity{

    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;  //상품 코드

    @Column(nullable=false, length = 50)
    private String itemNm;  //상품명

    @Column(name = "price", nullable = false)
    private int price;

    @Column(nullable=false)
    private int stockNumber;  //재고수량

    @Lob  // 글씨가 많을 경우 저장공간을 확보하는 어노테이션
    @Column(nullable=false)
    private String itemDetail; //상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품 판매 상태
    private LocalDateTime regTime; //등록 시간
    private LocalDateTime updateTime; //수정 시간

//    주문할 경우 남은 재고 줄임
    public void removeStock(int stockNumber) {
        int restStock = this.stockNumber - stockNumber;
//        남은 재고가 없을 경우
        if (restStock <= 0){
            throw new OutOfStockException("상품의 재고가 부족합니다. (현재 재고수량: " + this.stockNumber + ")");
        }
        this.stockNumber = restStock;
    }

//    주문취소할 경우 남은 재고 되돌림
    public void addStock(int stockNumber) {
        this.stockNumber += stockNumber;
    }

    public void updateItem(ItemFormDto itemFormDto){
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }
}
