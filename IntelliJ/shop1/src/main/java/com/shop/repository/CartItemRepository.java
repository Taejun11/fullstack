package com.shop.repository;

import com.shop.dto.CartDetailDto;
import com.shop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//장바구니에 들어갈 상품을 저장하거나 조회
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndItemId(Long cartId, Long itemId);

    @Query("select new com.shop.dto.CartDetailDto(ci.id, i.itemNm, i.price, ci.count, im.imgUrl) " +
            "from CartItem ci, ItemImg im " +
            "join ci.item i " +
            "where ci.cart.id = :cartId " +
            "and im.item.id = ci.item.id " +
            "and im.repimgYn = 'Y' " +
            "order by ci.regTime desc"
    )
    List<CartDetailDto> findCartDetailDtoList(Long cartId);

/*    @Query("SELECT new com.shop.dto.CartDetailDto(ci.id, i.itemNm, i.price, ci.count, im.imgUrl) " +
            "FROM CartItem ci " +
            "JOIN ci.item i " +
            "JOIN ItemImg im ON im.item.id = i.id " +
            "WHERE ci.cart.id = :cartId " +
            "AND im.repimgYn = 'Y' " +
            "ORDER BY ci.regTime DESC")
    List<CartDetailDto> findCartDetailDtoList(@Param("cartId") Long cartId);*/
}
