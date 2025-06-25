package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDetailDto {
    private Long cartItemId; //장바구니 상품 아이디
    private String itemNm; //상품명
    private int price; //상품 금액
    private int count; //상품 수량
    private String imgUrl; //상품 이미지 경로

    public CartDetailDto(Long cartItemId, String itemNm, int price, int count, String imgUrl) {
        this.cartItemId = cartItemId;
        this.itemNm = itemNm;
        this.price = price;
        this.count = count;
        this.imgUrl = imgUrl;
    }
/* CartItemRepository.findCartDetailDtoList()를 안할 경우
    @Transactional(readOnly = true)
    public List<CartDetailDto> getCartDetailList(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("회원이 존재하지 않습니다."));

        Cart cart = cartRepository.findByMemberId(member.getId());

        if (cart == null) {
            return Collections.emptyList();
        }

        List<CartItem> cartItems = cartItemRepository.findCartItemsWithItem(cart.getId());

        return cartItems.stream()
                .map(ci -> {
                    // 대표 이미지 가져오기
                    ItemImg repImg = itemImgRepository.findFirstByItemIdAndRepimgYn(ci.getItem().getId(), "Y");
                    return new CartDetailDto(
                            ci.getId(),
                            ci.getItem().getItemNm(),
                            ci.getItem().getPrice(),
                            ci.getCount(),
                            repImg != null ? repImg.getImgUrl() : null
                    );
                })
                .collect(Collectors.toList());
    }*/
}
