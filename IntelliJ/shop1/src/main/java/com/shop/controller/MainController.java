package com.shop.controller;

import com.shop.dto.ItemSearchDto;
import com.shop.dto.MainItemDto;
import com.shop.entity.Item;
import com.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ItemService itemService;

    @GetMapping("/")
    public String main(ItemSearchDto itemSearchDto, @PathVariable("page") Optional<Integer> page //페이지 번호가 없을 수 있음
            , Model model) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
//        페이지 번호가 있을경우 페이지 번호 받음, 없을 경우 0번으로 받음, 한 페이지에 3개씩
        Page<MainItemDto> items = itemService.getMainItemPage(itemSearchDto, pageable);
//        검색조건과 페이지 정보를 전달하여 목록 조회하는 함수
        model.addAttribute("items", items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 5);
        return "main";
    }
}
