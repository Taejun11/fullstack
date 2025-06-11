package com.springboot.domain;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Member {
    @MemberId
    private String memberId;

    @Size(min = 4, max = 10, message = "4자~10자 사이의 값으로 입력")
    private String passwd;
}
